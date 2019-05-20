package proz.models;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AnswerDataModel
{
    private static ObservableList<AnswerFxModel> answers = FXCollections.observableArrayList();
    private static ObjectProperty<AnswerFxModel> answer = new SimpleObjectProperty<>();

    private AnswerDataModel() {}

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

    public static AnswerFxModel getAnswer()
    {
        return answer.get();
    }

    public static ObjectProperty<AnswerFxModel> answerProperty()
    {
        return answer;
    }

    public static void setAnswer(AnswerFxModel answer)
    {
        AnswerDataModel.answer.set(answer);
    }
}
