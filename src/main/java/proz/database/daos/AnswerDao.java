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
        try {
            this.getDao(Answer.class).executeRaw("delete from ANSWERS where QUESTION_ID = " + questionId);
        } catch (SQLException e) {
            throw new ApplicationException("Delete answers to question error");
        } finally {
            try {
                this.connectionSource.close();
            } catch (IOException e) {
                throw new ApplicationException("Close connection error when deleting answers to question: " + questionId);
            }
        }

    }

    public List<Answer> queryForAnswersFromTest(int testId) throws ApplicationException
    {
        try {
            QueryBuilder<Answer, Object> queryBuilder = getQueryBuilder(Answer.class);
            QuestionDao questionDao = new QuestionDao();
            return queryBuilder.where().in("QUESTION_ID",
                    questionDao.queryForQuestionsFromTest(testId)).query();
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

    public List<Answer> queryForAnswersFromQuestion(int questionId) throws ApplicationException
    {
        List<Answer> list = null;
        try {
            list = getDao(Answer.class).queryForEq("QUESTION_ID", questionId);
        } catch (SQLException e) {
            throw new ApplicationException("Error while querying for answer to question: " + questionId);
        } finally {
            try {
                this.connectionSource.close();
            } catch (IOException e) {
                throw new ApplicationException("Close connection error when querying for answer to question: " + questionId);
            }        }
        return list;
    }
}
