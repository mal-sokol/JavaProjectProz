package proz.models;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AnswerDataModel
{
    private ObservableList<AnswerFxModel> answers = FXCollections.observableArrayList();
    private ObjectProperty<AnswerFxModel> answer = new SimpleObjectProperty<>();

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

    public ObservableList<AnswerFxModel> getAnswers()
    {
        return answers;
    }

    public void setAnswers(ObservableList<AnswerFxModel> answers)
    {
        this.answers = answers;
    }

    public AnswerFxModel getAnswer()
    {
        return answer.get();
    }

    public ObjectProperty<AnswerFxModel> answerProperty()
    {
        return answer;
    }

    public void setAnswer(AnswerFxModel answer)
    {
        this.answer.set(answer);
    }
}
