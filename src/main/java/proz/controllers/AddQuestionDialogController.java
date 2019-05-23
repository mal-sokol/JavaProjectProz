package proz.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import proz.database.models.Question;
import proz.models.AnswerDataModel;
import proz.utils.exceptions.ApplicationException;

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
    private Button saveButton;
    @FXML
    private Button cancelButton;


    private void disableSaveButtonUntilAllFieldsFilled()
    {
        saveButton.disableProperty().bind(questionTextField.textProperty().isEmpty().or(a1TextField.textProperty().isEmpty())
                .or(a2TextField.textProperty().isEmpty()).or(a3TextField.textProperty().isEmpty())
                .or(a4TextField.textProperty().isEmpty()));
    }

    @FXML
    private void initialize()
    {
        disableSaveButtonUntilAllFieldsFilled();
    }
    //TODO: zapis 4 na raz
    private void saveAnswers(Question question, String a1, boolean c1, String a2, boolean c2,
                             String a3, boolean c3, String a4, boolean c4) throws ApplicationException
    {
        AnswerDataModel.saveAnswerInDataBase(a1, c1, question);
        AnswerDataModel.saveAnswerInDataBase(a2, c2, question);
        AnswerDataModel.saveAnswerInDataBase(a3, c3, question);
        AnswerDataModel.saveAnswerInDataBase(a4, c4, question);
    }
//
//    @FXML
//    private void saveTestInDataBase(ActionEvent event)
//    {
//        Test test;
//        try {
//            test = TestDataModel.saveTestInDataBase(testNameTextField.getText(),
//                    CategoryConverter.categoryFxToCategory(CategoryDataModel.getCategory()));
//        Question question = QuestionDataModel.saveQuestionInDataBase(q1TextField.getText(), test);
//        saveAnswers(question, q1a1TextField.getText(), q1a1CheckBox.isSelected(),
//                q1a2TextField.getText(), q1a2CheckBox.isSelected(),
//                q1a3TextField.getText(), q1a3CheckBox.isSelected(),
//                q1a4TextField.getText(), q1a4CheckBox.isSelected());
//        question = QuestionDataModel.saveQuestionInDataBase(q2TextField.getText(), test);
//        saveAnswers(question, q2a1TextField.getText(), q2a1CheckBox.isSelected(),
//                q2a2TextField.getText(), q2a2CheckBox.isSelected(),
//                q2a3TextField.getText(), q2a3CheckBox.isSelected(),
//                q2a4TextField.getText(), q2a4CheckBox.isSelected());
//        question = QuestionDataModel.saveQuestionInDataBase(q3TextField.getText(), test);
//        saveAnswers(question, q3a1TextField.getText(), q3a1CheckBox.isSelected(),
//                q3a2TextField.getText(), q3a2CheckBox.isSelected(),
//                q3a3TextField.getText(), q3a3CheckBox.isSelected(),
//                q3a4TextField.getText(), q3a4CheckBox.isSelected());
//        question = QuestionDataModel.saveQuestionInDataBase(q4TextField.getText(), test);
//        saveAnswers(question, q4a1TextField.getText(), q4a1CheckBox.isSelected(),
//                q4a2TextField.getText(), q4a2CheckBox.isSelected(),
//                q4a3TextField.getText(), q4a3CheckBox.isSelected(),
//                q4a4TextField.getText(), q4a4CheckBox.isSelected());
//        question = QuestionDataModel.saveQuestionInDataBase(q5TextField.getText(), test);
//        saveAnswers(question, q5a1TextField.getText(), q5a1CheckBox.isSelected(),
//                q5a2TextField.getText(), q5a2CheckBox.isSelected(),
//                q5a3TextField.getText(), q5a3CheckBox.isSelected(),
//                q5a4TextField.getText(), q5a4CheckBox.isSelected());
//        } catch (ApplicationException e) {
//            DialogsUtils.errorDialog(e.getMessage());
//        }
//        Stage stage = (Stage) saveButton.getScene().getWindow();
//        stage.close();
//    }

    @FXML
    private void saveQuestionAndAnswers()
    {
    }

    @FXML
    private void cancelSaving()
    {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
}
