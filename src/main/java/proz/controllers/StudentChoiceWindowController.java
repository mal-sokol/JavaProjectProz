package proz.controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import proz.models.CategoryFxModel;
import proz.models.TestFxModel;
import proz.utils.DialogsUtils;
import proz.utils.FxmlUtils;

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

    private void disableBeginButtonUntilTestChosen()
    {
        beginTestButton.disableProperty().bind(testNameTable.getSelectionModel().selectedItemProperty().isNull());
    }

    //TODO: Tu trzeba będzie zrobić zapytanie do bazy o testy ktorych categoryId bedzie odpowiadało zaznaczonej kategorii
    // zwroconą listę trzeba bedzie załadować do testnameTable
    private void showAvailableTestsOnCategoryPicked()
    {
//        categoryTable.getSelectionModel().selectedItemProperty().addListener((observableValue, oldModelValue, newModelValue) ->
//                testNameTable.setItems(newModelValue.getListOfTests()));
    }

    // TODO: tutaj trzeba będzie zrobic zapytanie o wszystkie kategorie i umiescic je w categoryTable
    @FXML
    private void initialize()
    {
//        categoryTable.setItems(testData.getCategories());
        disableBeginButtonUntilTestChosen();
        showAvailableTestsOnCategoryPicked();
//        categoryTable.getSelectionModel().selectFirst();
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
