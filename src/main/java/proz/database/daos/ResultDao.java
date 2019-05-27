package proz.database.daos;

import proz.database.models.Result;
import proz.utils.exceptions.ApplicationException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

public class ResultDao extends CommonDao
{
    public ResultDao()
    {
        super();
    }

    public void deleteTestResults(int testId) throws ApplicationException
    {
        try {
            this.getDao(Result.class).executeRaw("delete from RESULT where TEST_ID = " + testId);
        } catch (SQLException e) {
            throw new ApplicationException("Error while deleting results from test nr: " + testId);
        } finally {
            try {
                this.connectionSource.close();
            } catch (IOException e) {
                throw new ApplicationException("Close connection error when deleting results from test" + testId);
            }
        }
    }

    public void deleteUserResults(int userId)  throws ApplicationException
    {
        try {
            this.getDao(Result.class).executeRaw("delete from RESULT where USER_ID = " + userId);
        } catch (SQLException e) {
            throw new ApplicationException("Error while deleting results from user nr: " + userId);
        } finally {
            try {
                this.connectionSource.close();
            } catch (IOException e) {
                throw new ApplicationException("Close connection error when deleting results from user nr: " + userId);
            }
        }
    }

    /*wyrzuca SQLException*/

//    public void deleteResultsFromDate(Date date) throws ApplicationException
//    {
//        try {
//            this.getDao(Result.class).executeRaw("delete from RESULT where DATA = " + date);
//        } catch (SQLException e) {
//            throw new ApplicationException("Error while deleting results from date: " + date.toString());
//        } finally {
//            try {
//                this.connectionSource.close();
//            } catch (IOException e) {
//                throw new ApplicationException("Close connection error when deleting results from date: " + date.toString());
//            }
//        }
//    }
    
    
    
}

