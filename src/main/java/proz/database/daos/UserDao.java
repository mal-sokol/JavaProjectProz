package proz.database.daos;

import com.j256.ormlite.stmt.QueryBuilder;
import proz.database.models.User;
import proz.utils.exceptions.ApplicationException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class UserDao extends CommonDao
{
    public UserDao()
    {
        super();
    }

    public List<User> queryForUser(UserDao dao, String username, String password, boolean isTeacher) throws ApplicationException
    {
        QueryBuilder<User, Object> queryBuilder = dao.getQueryBuilder(User.class);
        try
        {
            return queryBuilder.where().eq("USERNAME", username).and().eq("PASSWORD", password).
                    and().eq("TEACHER", isTeacher).query();
        }
        catch (SQLException e)
        {
            throw new ApplicationException("Query for user error");
        }
        finally
        {
            try {
                this.connectionSource.close();
            } catch (IOException e) {
                throw new ApplicationException("Close connection error");
            }
        }
    }
}
