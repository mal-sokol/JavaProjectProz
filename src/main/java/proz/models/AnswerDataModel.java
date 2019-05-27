package proz.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import proz.database.daos.AnswerDao;
import proz.database.models.Answer;
import proz.database.models.Question;
import proz.utils.converters.AnswerConverter;
import proz.utils.exceptions.ApplicationException;

import java.util.Collection;
import java.util.List;

public class AnswerDataModel
{
    private static ObservableList<AnswerFxModel> answersFromQuestion = FXCollections.observableArrayList();// LISTA ODPOWIEDZI DLA ZAZNACZONEGO PYTANIA
    private static ObservableList<AnswerFxModel> answers = FXCollections.observableArrayList();
    private static AnswerDao answerDao = new AnswerDao();

    private AnswerDataModel() {}

    public static void saveAnswerInDataBase(String answer, boolean isCorrect, Question question) throws ApplicationException
    {
        answerDao.createOrUpdate(new Answer(answer, isCorrect, question));
    }

    public static void saveManyAnswersInDataBase(Collection<Answer> answers) throws ApplicationException
    {
        answerDao.createMany(answers);
    }

    private static void populateAnswersFromQuestion(List<Answer> answerList)
    {
        answersFromQuestion.clear();
        answerList.forEach(answer -> {
            AnswerFxModel answerFx = AnswerConverter.answerToAnswerFx(answer);
            answersFromQuestion.add(answerFx);
        });
    }

    public static void getAnswersFromQuestion(int questionId) throws ApplicationException
    {
        List<Answer> answers = answerDao.queryForAnswersFromQuestion(questionId);
        populateAnswersFromQuestion(answers);
    }

    private static void populateAnswers(List<Answer> answerList)
    {
        answers.clear();
        answerList.forEach(answer -> {
            AnswerFxModel answerFx = AnswerConverter.answerToAnswerFx(answer);
            answers.add(answerFx);
        });
    }

    public static void getAnswersFromTest(int testId) throws ApplicationException
    {
        List<Answer> answers = answerDao.queryForAnswersFromTest(testId);
        populateAnswers(answers);
    }

    public static void updateAnswersInDataBase() throws ApplicationException
    {
        for(AnswerFxModel answer : answersFromQuestion)
            answerDao.update(AnswerConverter.answerFxToAnswer(answer));
    }

    public void fetchDataFromDataBase()
    {
//        AnswerDao answerDao = new AnswerDao(); // nowy dao
//        List<Answer> answersFromQuestion = answerDao.queryForAll(Answer.class); // sciagniecie wszystkich odpowiedzi
//        populateAnswersFromQuestion();// wrzucenie ich do datamodelu
    }

    public void deleteAnswerById()
    {
//        AnswerDao answerDao = new AnswerDao();//nowy dao
//        answerDao.deleteById(Answer.class, answer.getValue().getAnswerId())//usuniecie zaznaczonej odpowiedzi
        // fetchDataFromDataBase();
//        // załozenie bedzi wywolane tylko przy usuwaniu z gory, jednej odpowiedzi nie da sie usunąc
    }

    public static ObservableList<AnswerFxModel> getAnswersFromQuestion()
    {
        return answersFromQuestion;
    }

    public static void setAnswersFromQuestion(ObservableList<AnswerFxModel> answersFromQuestion)
    {
        AnswerDataModel.answersFromQuestion = answersFromQuestion;
    }

    public static ObservableList<AnswerFxModel> getAnswers()
    {

        return answers;
    }

    public static void setAnswers(ObservableList<AnswerFxModel> answers)
    {
        AnswerDataModel.answers = answers;
    }

    public static AnswerDao getAnswerDao()
    {
        return answerDao;
    }
}
