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
    
    public void deleteAnswersToQuestion(int questionId) throws ApplicationException {
        List<Answer> toDelete;
        try {
            QueryBuilder<Answer, Object> queryBuilder = this.getQueryBuilder(Answer.class);
            toDelete = queryBuilder.where().eq("QUESTION_ID", questionId).query();
            if(!toDelete.isEmpty()) {
                for (Answer answer : toDelete) {
                    delete(answer);
                }
            }
        } catch (SQLException e) {
            throw new ApplicationException("Delete answers to question error");
        }
    }

    public List<Answer> queryForAnswersFromTest(AnswerDao dao, int testId) throws ApplicationException
    {
        try {
            QueryBuilder<Answer, Object> queryBuilder = dao.getQueryBuilder(Answer.class);
            QuestionDao questionDao = new QuestionDao();
            return queryBuilder.where().in("QUESTION_ID",
                    questionDao.queryForQuestionsFromTest(testId )).query();
        } catch (SQLException e) {
            throw new ApplicationException("Query for answers from test error");
        } finally {
            try {
                this.connectionSource.close();
            } catch (IOException e) {
                throw new ApplicationException("Close connection error when deleting answers to question");

            }
        }
    }
}
