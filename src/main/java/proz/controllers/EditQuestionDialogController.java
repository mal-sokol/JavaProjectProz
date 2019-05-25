package proz.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import proz.models.AnswerDataModel;
import proz.models.QuestionDataModel;
import proz.utils.DialogsUtils;
import proz.utils.exceptions.ApplicationException;

public class EditQuestionDialogController
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
    private Button editButton;
    @FXML
    private Button cancelButton;


    private void disableSaveButtonUntilAllFieldsFilled()
    {
        editButton.disableProperty().bind(questionTextField.textProperty().isEmpty().or(a1TextField.textProperty().isEmpty())
                .or(a2TextField.textProperty().isEmpty()).or(a3TextField.textProperty().isEmpty())
                .or(a4TextField.textProperty().isEmpty()).or(group.selectedToggleProperty().isNull()));
    }

    @FXML
    private void initialize()
    {
        disableSaveButtonUntilAllFieldsFilled();
    }

    private void setAnswersInDataModel()
    {
        AnswerDataModel.getAnswersFromQuestion().get(0).setAnswer(a1TextField.getText());
        AnswerDataModel.getAnswersFromQuestion().get(0).setIsCorrect(a1RadioButton.isSelected());
        AnswerDataModel.getAnswersFromQuestion().get(1).setAnswer(a2TextField.getText());
        AnswerDataModel.getAnswersFromQuestion().get(1).setIsCorrect(a2RadioButton.isSelected());
        AnswerDataModel.getAnswersFromQuestion().get(2).setAnswer(a3TextField.getText());
        AnswerDataModel.getAnswersFromQuestion().get(2).setIsCorrect(a3RadioButton.isSelected());
        AnswerDataModel.getAnswersFromQuestion().get(3).setAnswer(a4TextField.getText());
        AnswerDataModel.getAnswersFromQuestion().get(3).setIsCorrect(a4RadioButton.isSelected());
    }

    @FXML
    private void editQuestionAndAnswers()
    {
        QuestionDataModel.getQuestion().setQuestion(questionTextField.getText());
        setAnswersInDataModel();

        try {
            QuestionDataModel.updateQuestionInDataBase();
            AnswerDataModel.updateAnswersInDataBase();
        } catch (ApplicationException e) {
            DialogsUtils.errorDialog(e.getMessage());
        }

        Stage stage = (Stage) editButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void cancelEditing()
    {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void setViewElementsToTheirExistingValues()
    {
        questionTextField.setText(QuestionDataModel.getQuestion().getQuestion());
        a1TextField.setText(AnswerDataModel.getAnswersFromQuestion().get(0).getAnswer());
        a1RadioButton.setSelected(AnswerDataModel.getAnswersFromQuestion().get(0).isIsCorrect());
        a2TextField.setText(AnswerDataModel.getAnswersFromQuestion().get(1).getAnswer());
        a2RadioButton.setSelected(AnswerDataModel.getAnswersFromQuestion().get(1).isIsCorrect());
        a3TextField.setText(AnswerDataModel.getAnswersFromQuestion().get(2).getAnswer());
        a3RadioButton.setSelected(AnswerDataModel.getAnswersFromQuestion().get(2).isIsCorrect());
        a4TextField.setText(AnswerDataModel.getAnswersFromQuestion().get(3).getAnswer());
        a4RadioButton.setSelected(AnswerDataModel.getAnswersFromQuestion().get(3).isIsCorrect());
    }
}
