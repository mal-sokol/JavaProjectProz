package proz.models;

import com.j256.ormlite.stmt.QueryBuilder;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import proz.database.daos.QuestionDao;
import proz.database.models.Question;
import proz.database.models.Test;
import proz.utils.converters.QuestionConverter;
import proz.utils.exceptions.ApplicationException;

import java.sql.SQLException;
import java.util.List;

public class QuestionDataModel
{
    private ObservableList<QuestionFxModel> questions = FXCollections.observableArrayList();
    private ObjectProperty<QuestionFxModel> question = new SimpleObjectProperty<>();

    public void fetchQuestionsForTest(Test test) throws ApplicationException, SQLException {
        QuestionDao questionDao = new QuestionDao();
        QueryBuilder<Question, Integer> testQueryBuilder = questionDao.getQueryBuilder(Question.class);
        List<Question> list = testQueryBuilder.where().eq("TEST_ID", test).query();
        populateQuestions(list);
    }

    private void populateQuestions(List<Question> list)
    {
        questions.clear();
        list.forEach(question -> {
            QuestionFxModel questionFx = QuestionConverter.questionToQuestionFx(question);
            questions.add(questionFx);
        });
    }

    public ObservableList<QuestionFxModel> getQuestions() {return questions;}
    public QuestionFxModel getQuestion() {return question.get();}

    public void setQuestions(ObservableList<QuestionFxModel> questions) {this.questions = questions;}
    public void setQuestion(QuestionFxModel question) {this.question.set(question);}
}
