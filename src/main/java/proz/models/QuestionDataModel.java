package proz.models;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import proz.database.daos.QuestionDao;
import proz.database.models.Question;
import proz.database.models.Test;
import proz.utils.converters.QuestionConverter;
import proz.utils.exceptions.ApplicationException;

import java.util.List;

public class QuestionDataModel
{
    private static ObservableList<QuestionFxModel> questions = FXCollections.observableArrayList(); // LISTA PYTAŃ DO ZAZNACZONEGO TESTU
    private static ObjectProperty<QuestionFxModel> question = new SimpleObjectProperty<>(); // ZAZNACZONE PYTANIE
    private static QuestionDao questionDao = new QuestionDao();

    private QuestionDataModel() {}

    private static void populateQuestions(List<Question> questionsList)
    {
        questions.clear();
        questionsList.forEach(question -> {
            QuestionFxModel questionFx = QuestionConverter.questionToQuestionFx(question);
            questions.add(questionFx);
        });
    }

    public static void getQuestionsFromTest(int testId) throws ApplicationException
    {
        List<Question> questions = questionDao.queryForQuestionsFromTest(testId);
        populateQuestions(questions);
    }

    public static Question saveQuestionInDataBase(String question, Test test) throws ApplicationException
    {
        Question newQuestion = new Question();
        newQuestion.setQuestion(question);
        newQuestion.setTestId(test);
        questionDao.createOrUpdate(newQuestion);
        questionDao.refresh(newQuestion);
        return newQuestion;
    }

    public static QuestionDao getQuestionDao()
    {
        return questionDao;
    }

    public static ObservableList<QuestionFxModel> getQuestions()
    {
        return questions;
    }

    public static void setQuestions(ObservableList<QuestionFxModel> questions)
    {
        QuestionDataModel.questions = questions;
    }

    public static QuestionFxModel getQuestion()
    {
        return question.get();
    }

    public static ObjectProperty<QuestionFxModel> questionProperty()
    {
        return question;
    }

    public static void setQuestion(QuestionFxModel question)
    {
        QuestionDataModel.question.set(question);
    }
}
