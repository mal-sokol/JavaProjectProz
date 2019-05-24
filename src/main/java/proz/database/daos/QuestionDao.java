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

    public List<Question> queryForQuestionsFromTest(QuestionDao dao, int testId) throws ApplicationException
    {
        try {
            QueryBuilder<Question, Object> queryBuilder = dao.getQueryBuilder(Question.class);
            return queryBuilder.where().eq("TEST_ID", testId).query();
        } catch (SQLException e) {
            throw new ApplicationException("Query for questions from test error");
        } finally {
            try {
                this.connectionSource.close();
            } catch (IOException e) {
                throw new ApplicationException("Close connection error");
            }
        }
    }
}
