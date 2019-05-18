package proz.models;

import proz.database.daos.UserDao;
import proz.database.models.User;
import proz.utils.exceptions.ApplicationException;

import java.sql.SQLException;

public class UserDataModel
{

    /*PROPOZYCJA LOGOWANIA*/
    public boolean loggedAsTeacher(String username, String password) throws ApplicationException, SQLException {

        UserDao userDao = new UserDao();
        Boolean isLogged = userDao.getQueryBuilder(User.class).where().eq("USERNAME", username).and().eq("PASSWORD", password).and().eq("TEACHER", true).countOf() > 0;
        return isLogged;
    }

    public boolean loggedAsStudent(String username, String password) throws ApplicationException, SQLException {

        UserDao userDao = new UserDao();
        Boolean isLogged = userDao.getQueryBuilder(User.class).where().eq("USERNAME", username).and().eq("PASSWORD", password).countOf() > 0;
        return isLogged;
    }

}
