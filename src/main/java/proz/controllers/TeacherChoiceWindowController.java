package proz.controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.TableView;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import proz.models.CategoryFxModel;
import proz.models.TestFxModel;
import proz.utils.DialogsUtils;
import proz.utils.FxmlUtils;

import java.util.Optional;

public class TeacherChoiceWindowController implements ControlledScreen
{
    @FXML
    private TableView<CategoryFxModel> categoryTable;
    @FXML
    private TableView<TestFxModel> testNameTable;
    @FXML
    private Button beginTestButton;
    @FXML
    private BorderPane teacherChoicePanel;
    @FXML
    private ContextMenu categoryContextMenu;
    @FXML
    private ContextMenu testContextMenu;

    private ScreensController myController;

    private void disableBeginButtonUntilTestChosen()
    {
        beginTestButton.disableProperty().bind(testNameTable.getSelectionModel().selectedItemProperty().isNull());
    }

    private void disableContextMenusOptionsWhenCannotBeUsed()
    {
        categoryContextMenu.getItems().get(0).disableProperty().bind(categoryTable.getSelectionModel().
                selectedItemProperty().isNull());
        categoryContextMenu.getItems().get(2).disableProperty().bind(categoryTable.getSelectionModel().
                selectedItemProperty().isNull());
        testContextMenu.getItems().get(0).disableProperty().bind(testNameTable.getSelectionModel()
                .selectedItemProperty().isNull());
        testContextMenu.getItems().get(2).disableProperty().bind(testNameTable.getSelectionModel()
                .selectedItemProperty().isNull());
    }

    private void showAvailableTestsOnCategoryPicked()
    {
        categoryTable.getSelectionModel().selectedItemProperty().addListener((observableValue, oldModelValue, newModelValue) ->
        {
//            if(!categoryTable.getItems().isEmpty())
//                testNameTable.setItems(newModelValue.getListOfTests());
        });
    }

    //Metody o tych samych nazwach co w StudentChoiceWindowController mają mieć te same zadanie tutaj co tam, czytaj tamtejsze TODO
    @FXML
    private void initialize()
    {
//        categoryTable.setItems(testData.getCategories());
        disableBeginButtonUntilTestChosen();
        disableContextMenusOptionsWhenCannotBeUsed();
        showAvailableTestsOnCategoryPicked();
//        categoryTable.getSelectionModel().selectFirst();
    }

    @FXML
    private void logout()
    {
        FxmlUtils.switchScene("/fxmlFiles/StartWindow.fxml", teacherChoicePanel,
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
    private void showEditGuideDialog()
    {
        DialogsUtils.teacherEditingDialog();
    }

    @FXML
    private void showAddGuideDialog()
    {
        DialogsUtils.teacherAddingDialog();
    }

    @FXML
    private void showDeleteGuideDialog()
    {
        DialogsUtils.teacherDeletingDialog();
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
    //TODO: dodawanie bezpośrednio do bazy danych przez dialog, następnie usuniecie zawartośći
    // z category table i ponowne wczytanie jej z bazy danych albo aktualizacja zawartości w zalezności od tego co prostsze
    @FXML
    private void addCategory()
    {
        Optional<String> newCategory = DialogsUtils.addCategoryDialog();
        if(newCategory.isPresent() && !newCategory.get().trim().isEmpty())
        {
//            ObservableList<TestFxModel> newTests = FXCollections.observableArrayList();
//            testData.getCategories().add(new CategoryFxModel(newCategory.get(), 4, newTests));
//            //testNameTable.getItems().clear();
//            //categoryTable.getItems().add(new CategoryFxModel(newCategory.get(), 4, newTests));
//            //categoryTable.getSelectionModel().clearSelection();
//            //categoryTable.getItems().clear();
//            //categoryTable.setItems(testData.getCategories());
//            categoryTable.getSelectionModel().selectLast();
        }
    }

    //TODO: dodawanie bezpośrednio do bazy danych przez dialog ktory trzeba jeszcze stworzyć, nastepnie usuniecie zawartosci
    // z test table i ponowne wczytanie jej z bazy danych albo aktualizacja zawartości w zalezności od tego co prostsze
    @FXML
    private void addTest()
    {
        if(categoryTable.getSelectionModel().selectedItemProperty().isNotNull().get())
        {
            Optional<String> newTest = DialogsUtils.addTestDialog();
            if(newTest.isPresent() && !newTest.get().trim().isEmpty())
            {

//                categoryTable.getSelectionModel().selectedItemProperty().get().getListOfTests().add(
//                        new TestFxModel(newTest.get(), 4));
                //testNameTable.getItems().add(new TestFxModel(newTest.get(), 4));
                //testNameTable.setItems(categoryTable.getSelectionModel().selectedItemProperty().get().getListOfTests());
            }
        }
        else
        {
            DialogsUtils.categoryNotSelectedDialog();
        }
    }

    private void editCategoryWhenDialogFilled(CategoryFxModel selectedCategory, Optional<String> editedCategory)
    {
        if(editedCategory.isPresent() && !editedCategory.get().trim().isEmpty())
        {
            selectedCategory.setCategoryName(editedCategory.get());
        }
    }
    //TODO: zapis zmiany do bazy danych, następnie usuniecie zawartośći
    // z category table i ponowne wczytanie jej z bazy danych albo aktualizacja zawartości w zalezności od tego co prostsze
    @FXML
    private void editCategory()
    {
        CategoryFxModel selectedCategory = categoryTable.getSelectionModel().getSelectedItem();
        if(selectedCategory == null)
        {
            DialogsUtils.categoryNotSelectedDialog();
        }
        else
        {
            Optional<String> editedCategory = DialogsUtils.editCategoryDialog(selectedCategory.getCategoryName());
            editCategoryWhenDialogFilled(selectedCategory, editedCategory);
        }
    }

    //TODO: to samo co wyzej tylko dla testu z uzyciem dialogu testu
    @FXML
    private void editTest(ActionEvent event)
    {
    }

    private void deleteCategoryWhenOkPressed(CategoryFxModel selectedCategory, Optional<ButtonType> result)
    {
        if(result.isPresent() && result.get() == ButtonType.OK)
        {
//            testNameTable.getItems().clear();
//            testData.getCategories().remove(selectedCategory);
        }
    }
    //TODO: usuniecie z bd
    @FXML
    private void deleteCategory()
    {
        CategoryFxModel selectedCategory = categoryTable.getSelectionModel().getSelectedItem();
        if(selectedCategory == null)
        {
            DialogsUtils.categoryNotSelectedDialog();
        }
        else
        {
            Optional<ButtonType> result = DialogsUtils.deleteCategoryConfirmationDialog();
            deleteCategoryWhenOkPressed(selectedCategory, result);
        }
    }

    private void deleteTestWhenOkPressed(CategoryFxModel selectedCategory, TestFxModel selectedTest, Optional<ButtonType> result)
    {
        if(result.isPresent() && result.get() == ButtonType.OK)
        {
//            testData.getCategories().get(testData.getCategories().indexOf(selectedCategory)).getListOfTests().
//                    remove(selectedTest);
        }
    }

    //TODO: usunięcie bazy danych, następnie usuniecie zawartośći
    // z test table i ponowne wczytanie jej z bazy danych albo aktualizacja zawartości w zalezności od tego co prostsze
    @FXML
    private void deleteTest()
    {
        CategoryFxModel selectedCategory = categoryTable.getSelectionModel().getSelectedItem();
        TestFxModel selectedTest = testNameTable.getSelectionModel().getSelectedItem();
        if(selectedTest == null)
        {
            DialogsUtils.testNotSelectedDialog();
        }
        else
        {
            Optional<ButtonType> result = DialogsUtils.deleteTestConfirmationDialog();
            deleteTestWhenOkPressed(selectedCategory, selectedTest, result);
        }
    }

    @Override
    public void setScreenParent(ScreensController screenParent) {
        myController = screenParent;
    }
}
