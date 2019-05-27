package proz.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;
import proz.models.AnswerDataModel;
import proz.models.ResultDataModel;
import proz.models.TestDataModel;
import proz.models.UserDataModel;
import proz.utils.DialogsUtils;
import proz.utils.FxmlUtils;
import proz.utils.converters.TestConverter;
import proz.utils.converters.UserConverter;
import proz.utils.exceptions.ApplicationException;

import java.util.Random;
import java.util.Vector;

import static proz.models.AnswerDataModel.getAnswers;
import static proz.models.QuestionDataModel.getQuestions;
import static proz.models.TestDataModel.getTest;

public class TestWindowController {

    @FXML
    private Label testName;
    @FXML
    private Label question1;
    @FXML
    private Label question2;
    @FXML
    private Label question3;
    @FXML
    private Label question4;
    @FXML
    private Label question5;
    @FXML
    private RadioButton button11;
    @FXML
    private RadioButton button12;
    @FXML
    private RadioButton button13;
    @FXML
    private RadioButton button14;
    @FXML
    private RadioButton button21;
    @FXML
    private RadioButton button22;
    @FXML
    private RadioButton button23;
    @FXML
    private RadioButton button24;
    @FXML
    private RadioButton button31;
    @FXML
    private RadioButton button32;
    @FXML
    private RadioButton button33;
    @FXML
    private RadioButton button34;
    @FXML
    private RadioButton button41;
    @FXML
    private RadioButton button42;
    @FXML
    private RadioButton button43;
    @FXML
    private RadioButton button44;
    @FXML
    private RadioButton button51;
    @FXML
    private RadioButton button52;
    @FXML
    private RadioButton button53;
    @FXML
    private RadioButton button54;
    @FXML
    private Label score;
    @FXML
    private Button checkButton;
    @FXML
    private Button backButton;
    @FXML
    private ToggleGroup answers1;
    @FXML
    private ToggleGroup answers2;
    @FXML
    private ToggleGroup answers3;
    @FXML
    private ToggleGroup answers4;
    @FXML
    private ToggleGroup answers5;

    private Vector<RadioButton> correct;
    private Vector<RadioButton> answers;


    private int sum = 0;

    @FXML
    private void initialize() throws ApplicationException
    {
        correct = new Vector<>();
        testName.setText(getTest().getTestName());

        AnswerDataModel.getAnswersFromTest(getTest().getTestId());
        if(getQuestions().size() > 5)
            chooseQuestions();

        question1.setText(getQuestions().get(0).getQuestion());
        question2.setText(getQuestions().get(1).getQuestion());
        question3.setText(getQuestions().get(2).getQuestion());
        question4.setText(getQuestions().get(3).getQuestion());
        question5.setText(getQuestions().get(4).getQuestion());
        score.setText("");
        backButton.setVisible(false);
        setCorrectAnswers();

    }

    private void setCorrectAnswers()
    {
        Vector<RadioButton> questionButtons = new Vector<>();
        for(int j = 0; j < 5; j++)
        {
            questionButtons.removeAllElements();
            questionButtons = getButtonsToQuestion(j);
            int index = 0;
            for (int i = 0; i < getAnswers().size(); i++)
            {
                if(getAnswers().get(i).getQuestionId().getQuestionId() == getQuestions().get(j).getQuestionId())
                {
                    questionButtons.get(index).setText(getAnswers().get(i).getAnswer());
                    if (getAnswers().get(i).isIsCorrect())
                    {
                        correct.add(getButtonsToQuestion(j).get(index));
                    }
                    index++;
                }
            }
        }
    }

    private Vector<RadioButton> getButtonsToQuestion(int questionNumber)
    {
        Vector<RadioButton> radioButtons = new Vector<>();
        switch (questionNumber)
        {
            case 0:
            {
                radioButtons.add(button11);
                radioButtons.add(button12);
                radioButtons.add(button13);
                radioButtons.add(button14);
                break;
            }
            case 1:
            {
                radioButtons.add(button21);
                radioButtons.add(button22);
                radioButtons.add(button23);
                radioButtons.add(button24);
                break;
            }
            case 2:
            {
                radioButtons.add(button31);
                radioButtons.add(button32);
                radioButtons.add(button33);
                radioButtons.add(button34);
                break;
            }
            case 3:
            {
                radioButtons.add(button41);
                radioButtons.add(button42);
                radioButtons.add(button43);
                radioButtons.add(button44);
                break;
            }
            case 4:
            {
                radioButtons.add(button51);
                radioButtons.add(button52);
                radioButtons.add(button53);
                radioButtons.add(button54);
                break;
            }

        }
        return radioButtons;
    }

    private void chooseQuestions()
    {
        Random random = new Random();
        int a;
        while( getQuestions().size() > 5)
        {
            a = random.nextInt(getQuestions().size());
            for (int i = 0; i < getAnswers().size(); i++)
            {
                if(getAnswers().get(i).getQuestionId().equals(getQuestions().get(a)))
                {
                    getAnswers().remove(i);
                    i--;
                }
            }
            getQuestions().remove(a);
        }
    }


    public void checkButtonAction()
    {
        if(storeAnswers())
        {
            backButton.setVisible(true);
            countCorrect();
            score.setText(sum + "/5 Points");
            if(sum < 4)
                score.setTextFill(Color.RED);
            else
                score.setTextFill(Color.GREEN);
            disableAllRadioButtons();
            saveResult();
            checkButton.setDisable(true);
        }
        else
            score.setText("All answers must be chosen!");
    }

    public void backButtonAction(ActionEvent actionEvent)
    {
        if(!UserDataModel.getCurrentUser().isIsTeacher())
            FxmlUtils.switchScene("/fxmlFiles/StudentChoiceWindow.fxml",
                    (Node) actionEvent.getSource(), "/images/student.png");
        else
            FxmlUtils.switchScene("/fxmlFiles/TeacherChoiceWindow.fxml",
                    (Node) actionEvent.getSource(), "/images/teacher.png");
    }

    private void saveResult()
    {
        try {
            ResultDataModel.saveResultInDataBase(sum, TestConverter.testFxToTest(TestDataModel.getTest()),
                    UserConverter.userFxToUser(UserDataModel.getCurrentUser()));
        } catch (ApplicationException e) {
            DialogsUtils.errorDialog(e.getMessage());
        }
    }

    private boolean storeAnswers()
    {
        answers = new Vector<>();
        answers.add((RadioButton) answers1.getSelectedToggle());
        answers.add((RadioButton) answers2.getSelectedToggle());
        answers.add((RadioButton) answers3.getSelectedToggle());
        answers.add((RadioButton) answers4.getSelectedToggle());
        answers.add((RadioButton) answers5.getSelectedToggle());
        for(int i = 0; i < 5; i++)
        {
            if(answers.get(i) == null)
                return false;
        }
        return true;
    }

    private void countCorrect()
    {

        for(int i = 0; i < 5; i++)
        {
            if(correct.get(i).equals(answers.get(i)))
            {
                answers.get(i).setTextFill(Color.GREEN);
                sum++;
            }
            else
                answers.get(i).setTextFill(Color.RED);
        }
    }

    private void disableAllRadioButtons()
    {
        button11.setDisable(true);
        button12.setDisable(true);
        button13.setDisable(true);
        button14.setDisable(true);
        button21.setDisable(true);
        button22.setDisable(true);
        button23.setDisable(true);
        button24.setDisable(true);
        button31.setDisable(true);
        button32.setDisable(true);
        button33.setDisable(true);
        button34.setDisable(true);
        button41.setDisable(true);
        button42.setDisable(true);
        button43.setDisable(true);
        button44.setDisable(true);
        button51.setDisable(true);
        button52.setDisable(true);
        button53.setDisable(true);
        button54.setDisable(true);
    }
}
