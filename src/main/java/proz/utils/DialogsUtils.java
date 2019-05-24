package proz.utils;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import java.util.Optional;

public class DialogsUtils
{
    private DialogsUtils() {}

    public static void aboutApplicationDialog()
    {
        Alert informationAlert = new Alert(Alert.AlertType.INFORMATION);
        informationAlert.setTitle("About this application");
        informationAlert.setHeaderText("SuperTester3000 - version 0.5");
        informationAlert.setContentText("Application created as a project for event-driven programming class.\n" +
                "This is a simple test system, results of tests are evaluated and recorded, new tests can be added," +
                " existing ones can be edited or deleted.\n" +
                "\nAuthors:\n" +
                "AuthorA, AuthorB\n" +
                "AuthorC, AuthorD\n");
        informationAlert.showAndWait();
    }
    public static void studentGuideDialog()
    {
        Alert informationAlert = new Alert(Alert.AlertType.INFORMATION);
        informationAlert.setTitle("How to solve test");
        informationAlert.setHeaderText("Follow these instructions to solve test.");
        informationAlert.setContentText("1. Choose category by clicking it with mouse.\n" +
                "2. After choosing category available tests will be shown.\n" +
                "3. Choose one of available tests and press \"Begin Test\" button to start test.\n" +
                "4. Each test has only one possible answer that can be selected with mouse.\n" +
                "5. After answering to all of questions press \"Show results\" button to finish and see the results.");
        informationAlert.showAndWait();
    }

    public static void unsuccessfulLoginDialog()
    {
        Alert informationAlert = new Alert(Alert.AlertType.INFORMATION);
        informationAlert.setTitle("Could not login");
        informationAlert.setHeaderText("Wrong username or password.");
        informationAlert.setContentText("Try different username or password.");
        informationAlert.showAndWait();
    }

    public static Optional<ButtonType> exitConfirmationDialog()
    {
        Alert confirmationDialog = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationDialog.setTitle("Exit");
        confirmationDialog.setHeaderText("Are you sure you want to exit?");
        confirmationDialog.setContentText("Press OK to confirm, otherwise press Cancel.");
        return confirmationDialog.showAndWait();
    }

    public static void errorDialog(String error)
    {
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setTitle("Error!");
        errorAlert.setHeaderText("Something went wrong!");
        TextArea textArea = new TextArea(error);
        errorAlert.getDialogPane().setContent(textArea);
        errorAlert.showAndWait();
    }

    public static void teacherEditingDialog()
    {
        Alert informationAlert = new Alert(Alert.AlertType.INFORMATION);
        informationAlert.setTitle("Editing items");
        informationAlert.setHeaderText("You can edit categories and tests.");
        informationAlert.setContentText("Follow these steps to edit an item:\n" +
                "1. Select item to edit.\n" +
                "2. Click on \"Edit\" in menu.\n" +
                "3. Choose \"Category\" or \"Test\".\n" +
                "4. Edit item and confirm change with \"OK\" button.\n");
        informationAlert.showAndWait();
    }

    public static void teacherAddingDialog()
    {
        Alert informationAlert = new Alert(Alert.AlertType.INFORMATION);
        informationAlert.setTitle("Adding items");
        informationAlert.setHeaderText("You can add categories and tests.");
        informationAlert.setContentText("Follow these steps to add an item:\n" +
                "1. Click on \"Add\" in menu.\n" +
                "2. Choose \"Category\" or \"Test\".\n" +
                "3. Add item and confirm with \"OK\" button.\n");
        informationAlert.showAndWait();
    }

    public static void teacherDeletingDialog()
    {
        Alert informationAlert = new Alert(Alert.AlertType.INFORMATION);
        informationAlert.setTitle("Deleting items");
        informationAlert.setHeaderText("You can delete categories and tests.");
        informationAlert.setContentText("Follow these steps to delete an item:\n" +
                "1. Select item to delete.\n" +
                "2. Click on \"Delete\" in menu.\n" +
                "3. Choose \"Category\" or \"Test\".\n" +
                "3. Confirm deletion.\n");
        informationAlert.showAndWait();
    }

    public static Optional<String> addCategoryDialog()
    {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Add category");
        dialog.setHeaderText("Add new category.");
        dialog.setContentText("Please enter category name: ");
        return dialog.showAndWait();
    }

    public static Optional<String> editCategoryDialog(String oldValue)
    {
        TextInputDialog dialog = new TextInputDialog(oldValue);
        dialog.setTitle("Edit category");
        dialog.setHeaderText("Edit selected category.");
        dialog.setContentText("Please enter new category name: ");
        return dialog.showAndWait();
    }

    public static Optional<String> addTestDialog()
    {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Add test");
        dialog.setHeaderText("Add new test.");
        dialog.setContentText("Please enter test name: ");
        return dialog.showAndWait();
    }

    public static Optional<String> editTestDialog(String oldValue)
    {
        TextInputDialog dialog = new TextInputDialog(oldValue);
        dialog.setTitle("Edit test");
        dialog.setHeaderText("Edit selected test.");
        dialog.setContentText("Please enter new test name: ");
        return dialog.showAndWait();
    }

    public static void categoryNotSelectedDialog()
    {
        Alert informationAlert = new Alert(Alert.AlertType.INFORMATION);
        informationAlert.setTitle("Error - item not selected");
        informationAlert.setHeaderText("Category was not selected.");
        informationAlert.setContentText("Select one of categories to perform this action.");
        informationAlert.showAndWait();
    }

    public static void testNotSelectedDialog()
    {
        Alert informationAlert = new Alert(Alert.AlertType.INFORMATION);
        informationAlert.setTitle("Error - item not selected");
        informationAlert.setHeaderText("Test was not selected.");
        informationAlert.setContentText("Select one of tests to perform this action.");
        informationAlert.showAndWait();
    }

    public static Optional<ButtonType> deleteCategoryConfirmationDialog()
    {
        Alert confirmationDialog = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationDialog.setTitle("Delete category");
        confirmationDialog.setHeaderText("Are you sure you want to delete this category?");
        confirmationDialog.setContentText("If you delete category, tests belonging to it will be deleted too.\n" +
                "Press OK to confirm, otherwise press Cancel.");
        return confirmationDialog.showAndWait();
    }

    public static Optional<ButtonType> deleteTestConfirmationDialog()
    {
        Alert confirmationDialog = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationDialog.setTitle("Delete test");
        confirmationDialog.setHeaderText("Are you sure you want to delete this test?");
        confirmationDialog.setContentText("Press OK to confirm, otherwise press Cancel.");
        return confirmationDialog.showAndWait();
    }
}
