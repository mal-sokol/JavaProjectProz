package proz.controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import proz.models.*;
import proz.utils.DialogsUtils;
import proz.utils.FxmlUtils;
import proz.utils.exceptions.ApplicationException;

import java.sql.SQLException;
import java.util.Optional;

public class StudentChoiceWindowController
{
    @FXML
    private TableView<CategoryFxModel> categoryTable;
    @FXML
    private TableView<TestFxModel> testNameTable;
    @FXML
    private Button beginTestButton;
    @FXML
    private Pane userChoicePanel;

    private CategoryDataModel categoryDataModel;
    private TestDataModel testDataModel;


    private void disableBeginButtonUntilTestChosen()
    {
        beginTestButton.disableProperty().bind(testNameTable.getSelectionModel().selectedItemProperty().isNull());
    }

    private void showAvailableTestsOnCategoryPicked()
    {
        categoryTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            CategoryDataModel.setCategory(newValue);
            if (CategoryDataModel.getCategory() != null)
            {
                try {
                    TestDataModel.getTestsFromCategory(CategoryDataModel.getCategory().getCategoryId());
                } catch (ApplicationException e) {
                    DialogsUtils.errorDialog(e.getMessage());
                }
            }
        });
    }

    private void loadQuestionsOnTestPicked()
    {
        testNameTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            TestDataModel.setTest(newValue);
            if(TestDataModel.getTest() != null)
            {
                try {
                    QuestionDataModel.getQuestionsFromTest(TestDataModel.getTest().getTestId());
                } catch (ApplicationException e) {
                    DialogsUtils.errorDialog(e.getMessage());
                }
            }
        });
    }

    private void fetchCategoryDataFromDataBase()
    {
        try {
            CategoryDataModel.fetchDataFromDataBase();
        } catch (ApplicationException e) {
            DialogsUtils.errorDialog(e.getMessage());
        }
    }

    @FXML
    private void initialize()
    {
        fetchCategoryDataFromDataBase();
        categoryTable.setItems(CategoryDataModel.getCategories());
        disableBeginButtonUntilTestChosen();
        showAvailableTestsOnCategoryPicked();
        loadQuestionsOnTestPicked();
        testNameTable.setItems(TestDataModel.getTests());
            if(!categoryTable.getItems().isEmpty())
        categoryTable.getSelectionModel().selectFirst();
    }

    @FXML
    private void logout()
    {
        UserDataModel.clearCurrentUser();
        FxmlUtils.switchScene("/fxmlFiles/StartWindow.fxml", userChoicePanel,
                "/images/testSys.png");
    }

    private void exitOnOkPressed(Optional<ButtonType> result)
    {
        if(result.isPresent() && result.get() == ButtonType.OK)
            Platform.exit();
    }

    @FXML
    private void exit()
    {
        Optional<ButtonType> result = DialogsUtils.exitConfirmationDialog();
        exitOnOkPressed(result);
    }
    @FXML
    private void showStudentGuideDialog()
    {
        DialogsUtils.studentGuideDialog();
    }

    @FXML
    private void highlightOnEnterButtonArea(MouseEvent mouseEvent)
    {
        if(mouseEvent.getEventType().equals(MouseEvent.MOUSE_ENTERED))
        {
            ((Button) mouseEvent.getSource()).setEffect(new DropShadow());
        }
    }

    @FXML
    private void stopHighlightingOnExitButtonArea(MouseEvent mouseEvent)
    {
        if(mouseEvent.getEventType().equals(MouseEvent.MOUSE_EXITED))
        {
            ((Button) mouseEvent.getSource()).setEffect(null);
        }
    }

    @FXML
    private void beginTest(ActionEvent event)
    {
    }
}
