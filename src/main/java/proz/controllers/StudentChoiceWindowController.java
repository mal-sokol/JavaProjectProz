package proz.controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import proz.database.models.Category;
import proz.models.CategoryDataModel;
import proz.models.CategoryFxModel;
import proz.models.TestDataModel;
import proz.models.TestFxModel;
import proz.utils.DialogsUtils;
import proz.utils.FxmlUtils;
import proz.utils.converters.CategoryConverter;
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

    /*PROPOZYCJA WYSWIETLANIA TESTOW*/
    private void showAvailableTestsOnCategoryPicked()
    {
        categoryTable.getSelectionModel().selectedItemProperty().addListener((observableValue, oldModelValue, newModelValue) -> {
            try {
                testDataModel.fetchTestsInCategory(CategoryConverter.categoryFxToCategory(newModelValue));
            } catch (ApplicationException e) {
                DialogsUtils.errorDialog(e.getMessage());
            } catch (SQLException e) {
                DialogsUtils.errorDialog("Database Error: " + e.getSQLState());
            }
            testNameTable.setItems(testDataModel.getTests());
        });

    }

    // TODO: tutaj trzeba będzie zrobic zapytanie o wszystkie kategorie i umiescic je w categoryTable
    @FXML
    private void initialize()
    {
        this.categoryDataModel = new CategoryDataModel();
        this.testDataModel = new TestDataModel();
        try {
            this.categoryDataModel.fetchDataFromDataBase();
        } catch (ApplicationException e) {
            DialogsUtils.errorDialog(e.getMessage());
        }
        categoryTable.setItems(categoryDataModel.getCategories());
        disableBeginButtonUntilTestChosen();
        showAvailableTestsOnCategoryPicked();
        categoryTable.getSelectionModel().selectFirst();
        bindTableView();
    }

    private void bindTableView() {
        this.testNameTable.setItems(this.testDataModel.getTests());

    }

    @FXML
    private void logout()
    {
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
}
