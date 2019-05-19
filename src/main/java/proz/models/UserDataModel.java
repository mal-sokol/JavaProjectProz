package proz.models;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class UserDataModel
{
    private static ObjectProperty<UserFxModel> currentUser = new SimpleObjectProperty<>();

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
}
