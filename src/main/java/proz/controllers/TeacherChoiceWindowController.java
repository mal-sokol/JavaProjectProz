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
import proz.models.*;
import proz.utils.DialogsUtils;
import proz.utils.FxmlUtils;
import proz.utils.converters.CategoryConverter;
import proz.utils.exceptions.ApplicationException;

import java.util.Optional;

public class TeacherChoiceWindowController
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
        testContextMenu.getItems().get(3).disableProperty().bind(testNameTable.getSelectionModel()
                .selectedItemProperty().isNull());
    }

    private void showAvailableTestsOnCategoryPicked()
    {
        categoryTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            CategoryDataModel.setCategory(newValue);
            if (CategoryDataModel.getCategory() != null)
            {
                try {
                    TestDataModel.getTestsFromCategory(CategoryDataModel.getCategory().getCategoryId());
                } catch (Exception e) {
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
        disableContextMenusOptionsWhenCannotBeUsed();
        if(!categoryTable.getItems().isEmpty())
            categoryTable.getSelectionModel().selectFirst();

    }

    @FXML
    private void logout()
    {
        UserDataModel.clearCurrentUser();
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

    @FXML
    private void addCategory()
    {
        Optional<String> newCategoryDialogResult = DialogsUtils.addCategoryDialog();
        if (newCategoryDialogResult.isPresent() && !newCategoryDialogResult.get().trim().isEmpty())
        {
            try {
                CategoryDataModel.saveCategoryInDataBase(newCategoryDialogResult.get());
            } catch (ApplicationException e) {
                DialogsUtils.errorDialog(e.getMessage());
            }
            categoryTable.getSelectionModel().selectLast();
        }

    }

    private void editCategoryWhenDialogFilled(Optional<String> editedCategory) throws ApplicationException
    {
        if(editedCategory.isPresent() && !editedCategory.get().trim().isEmpty())
        {
            CategoryDataModel.getCategory().setCategoryName(editedCategory.get());
            CategoryDataModel.updateCategoryInDataBase();
        }
    }

    @FXML
    private void editCategory()
    {
        if(CategoryDataModel.getCategory() == null)
        {
            DialogsUtils.categoryNotSelectedDialog();
        }
        else
        {
            Optional<String> editedCategoryDialogResult = DialogsUtils.editCategoryDialog(CategoryDataModel.getCategory().getCategoryName());
            try {
                editCategoryWhenDialogFilled(editedCategoryDialogResult);
            } catch (ApplicationException e) {
                DialogsUtils.errorDialog(e.getMessage());
            }
        }
    }


    @FXML
    private void addTest()
    {
        if (CategoryDataModel.getCategory() == null)
        {
            DialogsUtils.categoryNotSelectedDialog();
        } else
        {
            Optional<String> newTestDialogResult = DialogsUtils.addTestDialog();
            if (newTestDialogResult.isPresent() && !newTestDialogResult.get().trim().isEmpty())
            {
                try {
                    TestDataModel.saveTestInDataBase(newTestDialogResult.get(),
                            CategoryConverter.categoryFxToCategory(CategoryDataModel.getCategory()));
                } catch (ApplicationException e) {
                    DialogsUtils.errorDialog(e.getMessage());
                }
                testNameTable.getSelectionModel().selectLast();
            }
        }
    }

    private void editTestWhenDialogFilled(Optional<String> editedTestDialogResult) throws ApplicationException
    {
        if(editedTestDialogResult.isPresent() && !editedTestDialogResult.get().trim().isEmpty())
        {
            TestDataModel.getTest().setTestName(editedTestDialogResult.get());
            TestDataModel.updateTestInDataBase();
        }
    }

    @FXML
    private void editTest()
    {
        if(TestDataModel.getTest() == null)
        {
            DialogsUtils.testNotSelectedDialog();
        }
        else
        {
            Optional<String> editedTestDialogResult = DialogsUtils.editTestDialog((TestDataModel.getTest().getTestName()));
            try {
                editTestWhenDialogFilled(editedTestDialogResult);
            } catch (ApplicationException e) {
                DialogsUtils.errorDialog(e.getMessage());
            }
        }
    }

    @FXML
    private void addQuestion(ActionEvent event)
    {
        if(TestDataModel.getTest() == null)
        {
            DialogsUtils.testNotSelectedDialog();
        }
        else
        {
            FxmlUtils.createNewStageDialog("/fxmlFiles/AddQuestionDialog.fxml", "/images/teacher.png");
        }


    }

    @FXML
    private void showQuestionsToEdit(ActionEvent event)
    {
    }

    @FXML
    private void beginTest(ActionEvent event)
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

    @FXML
    private void showResults(ActionEvent event)
    {
    }
}
