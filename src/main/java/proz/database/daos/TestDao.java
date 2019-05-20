package proz.database.daos;

import com.j256.ormlite.stmt.QueryBuilder;
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

    public List<Test> queryForTestsFromCategory(TestDao dao, int categoryId) throws ApplicationException
    {
        try
        {
            QueryBuilder<Test, Object> queryBuilder = dao.getQueryBuilder(Test.class);
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
}

