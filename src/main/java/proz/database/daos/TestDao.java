package proz.database.daos;

import com.j256.ormlite.stmt.QueryBuilder;
import proz.database.models.Question;
import proz.database.models.Test;
import proz.utils.exceptions.ApplicationException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class TestDao extends CommonDao
{
    public TestDao()
    {
        super();
    }

    public List<Test> queryForTestsFromCategory(int categoryId) throws ApplicationException
    {
        try
        {
            QueryBuilder<Test, Object> queryBuilder = getQueryBuilder(Test.class);
            return queryBuilder.where().eq("CATEGORY_ID", categoryId).query();
        }
        catch (SQLException e)
        {
            throw new ApplicationException("Query for tests from category error");
        }
        finally
        {
            try
            {
                this.connectionSource.close();
            }
            catch (IOException e)
            {
                throw new ApplicationException("Close connection error");
            }
        }
    }

    public void deleteTestsFromCategory(int categoryId) throws ApplicationException
    {
        List<Test> toDelete;
        try
        {
            QueryBuilder<Test, Object> queryBuilder = getQueryBuilder(Test.class);
            toDelete = queryBuilder.where().eq("CATEGORY_ID", categoryId).query();
            if(!toDelete.isEmpty()) {
                for (Test test : toDelete) {
                    QuestionDao questionDao = new QuestionDao();
                    questionDao.deleteQuestionsFromTest(test.getTestId());
                    delete(test);
                }
            }
        }
        catch (SQLException e)
        {
            throw new ApplicationException("Delete tests from category error");
        }
        finally
        {
            try
            {
                this.connectionSource.close();
            }
            catch (IOException e)
            {
                throw new ApplicationException("Close connection error when deleting tests from category");
            }
        }
    }

    public void deleteTestByid(int testId) throws ApplicationException
    {
        QuestionDao questionDao = new QuestionDao();
        questionDao.deleteQuestionsFromTest(testId);
        deleteById(Test.class, testId);
    }
}

