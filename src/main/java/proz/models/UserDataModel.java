package proz.models;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import proz.database.daos.UserDao;

public class UserDataModel
{
    private static ObjectProperty<UserFxModel> currentUser = new SimpleObjectProperty<>();
    private static UserDao userDao = new UserDao();

    private UserDataModel() {}

    public static UserFxModel getCurrentUser()
    {
        return currentUser.get();
    }

    public static ObjectProperty<UserFxModel> currentUserProperty()
    {
        return currentUser;
    }

    public static void setCurrentUser(UserFxModel currentUser)
    {
        UserDataModel.currentUser.set(currentUser);
    }

    public static void clearCurrentUser()
    {
        currentUser.set(null);
    }

    public static UserDao getUserDao()
    {
        return userDao;
    }
}
