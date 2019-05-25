package proz.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import proz.database.models.Answer;
import proz.database.models.Question;
import proz.models.AnswerDataModel;
import proz.models.QuestionDataModel;
import proz.models.TestDataModel;
import proz.utils.DialogsUtils;
import proz.utils.converters.TestConverter;
import proz.utils.exceptions.ApplicationException;

import java.util.ArrayList;
import java.util.List;

public class AddQuestionDialogController
{
    @FXML
    private TextField questionTextField;
    @FXML
    private TextField a1TextField;
    @FXML
    private RadioButton a1RadioButton;
    @FXML
    private TextField a2TextField;
    @FXML
    private RadioButton a2RadioButton;
    @FXML
    private TextField a3TextField;
    @FXML
    private RadioButton a3RadioButton;
    @FXML
    private TextField a4TextField;
    @FXML
    private RadioButton a4RadioButton;
    @FXML
    private ToggleGroup group;
    @FXML
    private Button saveButton;
    @FXML
    private Button cancelButton;


    private void disableSaveButtonUntilAllFieldsFilled()
    {
        saveButton.disableProperty().bind(questionTextField.textProperty().isEmpty().or(a1TextField.textProperty().isEmpty())
                .or(a2TextField.textProperty().isEmpty()).or(a3TextField.textProperty().isEmpty())
                .or(a4TextField.textProperty().isEmpty()).or(group.selectedToggleProperty().isNull()));
    }

    @FXML
    private void initialize()
    {
        disableSaveButtonUntilAllFieldsFilled();
    }

    private void populateListOfAnswers(Question question, List<Answer> answers)
    {
        answers.add(new Answer(a1TextField.getText(), a1RadioButton.isSelected(), question));
        answers.add(new Answer(a2TextField.getText(), a2RadioButton.isSelected(), question));
        answers.add(new Answer(a3TextField.getText(), a3RadioButton.isSelected(), question));
        answers.add(new Answer(a4TextField.getText(), a4RadioButton.isSelected(), question));
    }

    private Question saveQuestionInDataBase()
    {
        Question question = null;
        try {
            question = QuestionDataModel.saveQuestionInDataBase(questionTextField.getText(),
                    TestConverter.testFxToTest(TestDataModel.getTest()));
        } catch (ApplicationException e) {
            DialogsUtils.errorDialog(e.getMessage());
        }
        return question;
    }

    private void saveAnswersInDataBase(List<Answer> answers) {
        try {
            AnswerDataModel.saveManyAnswersInDataBase(answers);
        } catch (ApplicationException e) {
            DialogsUtils.errorDialog(e.getMessage());
        }
    }

    @FXML
    private void saveQuestionAndAnswers()
    {

        Question question = saveQuestionInDataBase();

        List<Answer> answers = new ArrayList<>();
        populateListOfAnswers(question, answers);
        saveAnswersInDataBase(answers);

        Stage stage = (Stage) saveButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void cancelSaving()
    {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
}
