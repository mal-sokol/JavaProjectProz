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
        } finally {
            try {
                this.connectionSource.close();
            } catch (IOException e) {
                throw new ApplicationException("Close connection error when deleting answers to question");
            }
        }
    }
}
