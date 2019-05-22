package proz.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import proz.database.daos.AnswerDao;
import proz.database.models.Answer;
import proz.database.models.Question;
import proz.utils.exceptions.ApplicationException;

public class AnswerDataModel
{
    private static ObservableList<AnswerFxModel> answers = FXCollections.observableArrayList(); // LISTA ODPOWIEDZI DLA ZAZNACZONEGO PYTANIA
   // private static ObjectProperty<AnswerFxModel> answer = new SimpleObjectProperty<>();
    private static AnswerDao answerDao = new AnswerDao();

    private AnswerDataModel() {}

    public static void saveAnswerInDataBase(String answer, boolean isCorrect, Question question) throws ApplicationException
    {
        Answer newAnswer = new Answer();
        newAnswer.setAnswer(answer);
        newAnswer.setCorrect(isCorrect);
        newAnswer.setQuestionId(question);
        answerDao.createOrUpdate(newAnswer);
    }

    private void populateAnswers()
    {
//        answers.clear();
//        answers.forEach(answer -> {
//            AnswerFxModel answerFx = AnswerConverter.answerToAnswerFx(answer);
//            answers.add(answerFx);
//        });
    }
    public void fetchDataFromDataBase()
    {
//        AnswerDao answerDao = new AnswerDao(); // nowy dao
//        List<Answer> answers = answerDao.queryForAll(Answer.class); // sciagniecie wszystkich odpowiedzi
//        populateAnswers();// wrzucenie ich do datamodelu
    }

    public void deleteAnswerById()
    {
//        AnswerDao answerDao = new AnswerDao();//nowy dao
//        answerDao.deleteById(Answer.class, answer.getValue().getAnswerId())//usuniecie zaznaczonej odpowiedzi
        // fetchDataFromDataBase();
//        // załozenie bedzi wywolane tylko przy usuwaniu z gory, jednej odpowiedzi nie da sie usunąc
    }

    public void saveAnswerInDataBase(String answer)
    {
//        AnswerDao answerDao = new AnswerDao();
//        Answer newAnswer = new Answer();
//        answer.setAnswer(answer);
//        answerDao.createOrUpdate(newAnswer);
//        fetchDataFromDataBase();
    }

    public void updateAnswerInDataBase()
    {
//        AnswerDao answerDao = new AnswerDao();
//        Answer updatedAnswer = answerDao.findById(Answer.class, getAnswer().getAnswerId());
//        updatedAnswer.setAnswer(getAnswer().getAnswer());
//        answerDao.createOrUpdate(updatedAnswer);
//        fetchDataFromDataBase();
    }

    public static ObservableList<AnswerFxModel> getAnswers()
    {
        return answers;
    }

    public static void setAnswers(ObservableList<AnswerFxModel> answers)
    {
        AnswerDataModel.answers = answers;
    }

//    public static AnswerFxModel getAnswer()
//    {
//        return answer.get();
//    }
//
//    public static ObjectProperty<AnswerFxModel> answerProperty()
//    {
//        return answer;
//    }
//
//    public static void setAnswer(AnswerFxModel answer)
//    {
//        AnswerDataModel.answer.set(answer);
//    }

    public static AnswerDao getAnswerDao()
    {
        return answerDao;
    }
}
