package proz.utils.converters;

import proz.database.models.User;
import proz.models.UserFxModel;

public class UserConverter
{
    private UserConverter() {}

    public static UserFxModel userToUserFx(User user)
    {
        UserFxModel fxModel = new UserFxModel();
        fxModel.setUserId(user.getUserId());
        fxModel.setUsername(user.getUsername());
        fxModel.setPassword(user.getPassword());
        fxModel.setIsTeacher(user.getTeacher());
        return fxModel;
    }
    public static User userFxToUser(UserFxModel fxModel)
    {
        User user = new User();
        user.setUserId(fxModel.getUserId());
        user.setUsername(fxModel.getUsername());
        user.setPassword(fxModel.getPassword());
        user.setTeacher(fxModel.isIsTeacher());
        return user;
    }

}
