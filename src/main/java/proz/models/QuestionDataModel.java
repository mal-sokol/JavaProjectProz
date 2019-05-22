package proz.models;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import proz.database.daos.QuestionDao;
import proz.database.models.Question;
import proz.database.models.Test;
import proz.utils.exceptions.ApplicationException;

public class QuestionDataModel
{
    private static ObservableList<TestFxModel> questions = FXCollections.observableArrayList();
    private static ObjectProperty<TestFxModel> question = new SimpleObjectProperty<>();
    private static QuestionDao questionDao = new QuestionDao();

    private QuestionDataModel() {}

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

    public static ObservableList<TestFxModel> getQuestions()
    {
        return questions;
    }

    public static void setQuestions(ObservableList<TestFxModel> questions)
    {
        QuestionDataModel.questions = questions;
    }

    public static TestFxModel getQuestion()
    {
        return question.get();
    }

    public static ObjectProperty<TestFxModel> questionProperty()
    {
        return question;
    }

    public static void setQuestion(TestFxModel question)
    {
        QuestionDataModel.question.set(question);
    }
}
