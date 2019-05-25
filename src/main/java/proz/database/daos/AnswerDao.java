package proz.database.daos;

import com.j256.ormlite.stmt.QueryBuilder;
import proz.database.models.Answer;
import proz.utils.exceptions.ApplicationException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AnswerDao extends CommonDao
{
    public AnswerDao()
    {
        super();
    }

    public List<Answer> queryForAnswersFromQuestion(AnswerDao dao, int questionId) throws ApplicationException
    {
        try {
            QueryBuilder<Answer, Object> queryBuilder = dao.getQueryBuilder(Answer.class);
            return queryBuilder.where().eq("QUESTION_ID", questionId).query();
        } catch (SQLException e) {
            throw new ApplicationException("Query for answers from question error");
        } finally {
            try {
                this.connectionSource.close();
            } catch (IOException e) {
                throw new ApplicationException("Close connection error");
            }
        }
    }
}
