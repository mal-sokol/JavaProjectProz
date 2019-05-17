package proz.models;

import javafx.beans.property.*;

public class UserFxModel
{
    private IntegerProperty userId = new SimpleIntegerProperty();
    private StringProperty username = new SimpleStringProperty();
    private StringProperty password = new SimpleStringProperty();
    private BooleanProperty isTeacher = new SimpleBooleanProperty();

    public int getUserId()
    {
        return userId.get();
    }

    public IntegerProperty userIdProperty()
    {
        return userId;
    }

    public void setUserId(int userId)
    {
        this.userId.set(userId);
    }

    public String getUsername()
    {
        return username.get();
    }

    public StringProperty usernameProperty()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username.set(username);
    }

    public String getPassword()
    {
        return password.get();
    }

    public StringProperty passwordProperty()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password.set(password);
    }

    public boolean isIsTeacher()
    {
        return isTeacher.get();
    }

    public BooleanProperty isTeacherProperty()
    {
        return isTeacher;
    }

    public void setIsTeacher(boolean isTeacher)
    {
        this.isTeacher.set(isTeacher);
    }
}
