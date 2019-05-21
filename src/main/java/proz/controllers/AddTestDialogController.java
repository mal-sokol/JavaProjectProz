package proz.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import proz.database.models.Question;
import proz.database.models.Test;
import proz.models.AnswerDataModel;
import proz.models.CategoryDataModel;
import proz.models.QuestionDataModel;
import proz.models.TestDataModel;
import proz.utils.DialogsUtils;
import proz.utils.converters.CategoryConverter;
import proz.utils.exceptions.ApplicationException;

public class AddTestDialogController
{
    @FXML
    private Button saveButton;
    @FXML
    private Button cancelButton;
    @FXML
    private TextField testNameTextField;
    @FXML
    private TextField q1TextField;
    @FXML
    private TextField q1a1TextField;
    @FXML
    private CheckBox q1a1CheckBox;
    @FXML
    private TextField q1a2TextField;
    @FXML
    private CheckBox q1a2CheckBox;
    @FXML
    private TextField q1a3TextField;
    @FXML
    private CheckBox q1a3CheckBox;
    @FXML
    private TextField q1a4TextField;
    @FXML
    private CheckBox q1a4CheckBox;
    @FXML
    private TextField q2TextField;
    @FXML
    private TextField q2a1TextField;
    @FXML
    private CheckBox q2a1CheckBox;
    @FXML
    private TextField q2a2TextField;
    @FXML
    private CheckBox q2a2CheckBox;
    @FXML
    private TextField q2a3TextField;
    @FXML
    private CheckBox q2a3CheckBox;
    @FXML
    private TextField q2a4TextField;
    @FXML
    private CheckBox q2a4CheckBox;
    @FXML
    private TextField q3TextField;
    @FXML
    private TextField q3a1TextField;
    @FXML
    private CheckBox q3a1CheckBox;
    @FXML
    private TextField q3a2TextField;
    @FXML
    private CheckBox q3a2CheckBox;
    @FXML
    private TextField q3a3TextField;
    @FXML
    private CheckBox q3a3CheckBox;
    @FXML
    private TextField q3a4TextField;
    @FXML
    private CheckBox q3a4CheckBox;
    @FXML
    private TextField q4TextField;
    @FXML
    private TextField q4a1TextField;
    @FXML
    private CheckBox q4a1CheckBox;
    @FXML
    private TextField q4a2TextField;
    @FXML
    private CheckBox q4a2CheckBox;
    @FXML
    private TextField q4a3TextField;
    @FXML
    private CheckBox q4a3CheckBox;
    @FXML
    private TextField q4a4TextField;
    @FXML
    private CheckBox q4a4CheckBox;
    @FXML
    private TextField q5TextField;
    @FXML
    private TextField q5a1TextField;
    @FXML
    private CheckBox q5a1CheckBox;
    @FXML
    private TextField q5a2TextField;
    @FXML
    private CheckBox q5a2CheckBox;
    @FXML
    private TextField q5a3TextField;
    @FXML
    private CheckBox q5a3CheckBox;
    @FXML
    private TextField q5a4TextField;
    @FXML
    private CheckBox q5a4CheckBox;

    private void disableSaveButtonUntilWholeTestFilled()
    {
        saveButton.disableProperty().bind(q1TextField.textProperty().isEmpty().or(q1a1TextField.textProperty().isEmpty())
                .or(q1a2TextField.textProperty().isEmpty()).or(q1a3TextField.textProperty().isEmpty())
                .or(q1a4TextField.textProperty().isEmpty())
                .or(q2TextField.textProperty().isEmpty()).or(q2a1TextField.textProperty().isEmpty())
                .or(q2a2TextField.textProperty().isEmpty()).or(q2a3TextField.textProperty().isEmpty())
                .or(q2a4TextField.textProperty().isEmpty())
                .or(q3TextField.textProperty().isEmpty()).or(q3a1TextField.textProperty().isEmpty())
                .or(q3a2TextField.textProperty().isEmpty()).or(q3a3TextField.textProperty().isEmpty())
                .or(q3a4TextField.textProperty().isEmpty())
                .or(q4TextField.textProperty().isEmpty()).or(q4a1TextField.textProperty().isEmpty())
                .or(q4a2TextField.textProperty().isEmpty()).or(q4a3TextField.textProperty().isEmpty())
                .or(q4a4TextField.textProperty().isEmpty())
                .or(q5TextField.textProperty().isEmpty()).or(q5a1TextField.textProperty().isEmpty())
                .or(q5a2TextField.textProperty().isEmpty()).or(q5a3TextField.textProperty().isEmpty())
                .or(q5a4TextField.textProperty().isEmpty()));
    }

    @FXML
    private void initialize()
    {
        disableSaveButtonUntilWholeTestFilled();
        cancelButton.setCancelButton(true);
    }
    private void saveAnswers(Question question, String a1, boolean c1, String a2, boolean c2,
                             String a3, boolean c3, String a4, boolean c4) throws ApplicationException
    {
        AnswerDataModel.saveAnswerInDataBase(a1, c1, question);
        AnswerDataModel.saveAnswerInDataBase(a2, c2, question);
        AnswerDataModel.saveAnswerInDataBase(a3, c3, question);
        AnswerDataModel.saveAnswerInDataBase(a4, c4, question);
    }

    @FXML
    private void saveTestInDataBase(ActionEvent event)
    {
        Test test;
        try {
            test = TestDataModel.saveTestInDataBase(testNameTextField.getText(),
                    CategoryConverter.categoryFxToCategory(CategoryDataModel.getCategory()));
        Question question = QuestionDataModel.saveQuestionInDataBase(q1TextField.getText(), test);
        saveAnswers(question, q1a1TextField.getText(), q1a1CheckBox.isSelected(),
                q1a2TextField.getText(), q1a2CheckBox.isSelected(),
                q1a3TextField.getText(), q1a3CheckBox.isSelected(),
                q1a4TextField.getText(), q1a4CheckBox.isSelected());
        question = QuestionDataModel.saveQuestionInDataBase(q2TextField.getText(), test);
        saveAnswers(question, q2a1TextField.getText(), q2a1CheckBox.isSelected(),
                q2a2TextField.getText(), q2a2CheckBox.isSelected(),
                q2a3TextField.getText(), q2a3CheckBox.isSelected(),
                q2a4TextField.getText(), q2a4CheckBox.isSelected());
        question = QuestionDataModel.saveQuestionInDataBase(q3TextField.getText(), test);
        saveAnswers(question, q3a1TextField.getText(), q3a1CheckBox.isSelected(),
                q3a2TextField.getText(), q3a2CheckBox.isSelected(),
                q3a3TextField.getText(), q3a3CheckBox.isSelected(),
                q3a4TextField.getText(), q3a4CheckBox.isSelected());
        question = QuestionDataModel.saveQuestionInDataBase(q4TextField.getText(), test);
        saveAnswers(question, q4a1TextField.getText(), q4a1CheckBox.isSelected(),
                q4a2TextField.getText(), q4a2CheckBox.isSelected(),
                q4a3TextField.getText(), q4a3CheckBox.isSelected(),
                q4a4TextField.getText(), q4a4CheckBox.isSelected());
        question = QuestionDataModel.saveQuestionInDataBase(q5TextField.getText(), test);
        saveAnswers(question, q5a1TextField.getText(), q5a1CheckBox.isSelected(),
                q5a2TextField.getText(), q5a2CheckBox.isSelected(),
                q5a3TextField.getText(), q5a3CheckBox.isSelected(),
                q5a4TextField.getText(), q5a4CheckBox.isSelected());
        } catch (ApplicationException e) {
            DialogsUtils.errorDialog(e.getMessage());
        }
        Stage stage = (Stage) saveButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void closeDialog(ActionEvent event)
    {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
}
