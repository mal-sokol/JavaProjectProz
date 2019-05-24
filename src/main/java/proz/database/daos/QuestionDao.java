package proz.database.daos;

import com.j256.ormlite.stmt.QueryBuilder;
import proz.database.models.Question;
import proz.utils.exceptions.ApplicationException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class QuestionDao extends CommonDao
{
    public QuestionDao()
    {
        super();
    }

    public void deleteQuestionsFromTest(int testId) throws ApplicationException {
        List<Question> toDelete;
        try {
            QueryBuilder<Question, Object> queryBuilder = getQueryBuilder(Question.class);
            toDelete = queryBuilder.where().eq("TEST_ID", testId).query();
            if (!toDelete.isEmpty()) {
                AnswerDao answerDao = new AnswerDao();
                for (Question question : toDelete) {
                    answerDao.deleteAnswersToQuestion(question.getQuestionId());
                    delete(question);
                }
            }
        } catch (SQLException e) {
            throw new ApplicationException("Delete questions from test error");
        }
    }

    public List<Question> queryForQuestionsFromTest(int testId) throws ApplicationException
    {
        try {
            QueryBuilder<Question, Object> queryBuilder = this.getQueryBuilder(Question.class);
            return queryBuilder.where().eq("TEST_ID", testId).query();
        } catch (SQLException e) {
            throw new ApplicationException("Query for questions from test error");
        } finally {
            try {
                this.connectionSource.close();
            } catch (IOException e) {
                throw new ApplicationException("Close connection error when deleting questions from test");
            }
        }
    }
}
