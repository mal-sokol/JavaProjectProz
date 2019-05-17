package proz.database.models;


import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "USER")
public class User implements BaseModel
{
    public User() {}

    @DatabaseField(generatedId = true, columnName = "USER_ID")
    private int userId;

    @DatabaseField(columnName = "USERNAME", canBeNull = false, unique = true)
    private String username;

    @DatabaseField(columnName = "TEACHER", canBeNull = false)
    private boolean isTeacher;

    @DatabaseField(columnName = "PASSWORD", canBeNull = false)
    private String password;

    public int getUserId()
    {
        return userId;
    }

    public void setUserId(int userId)
    {
        this.userId = userId;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public boolean getTeacher()
    {
        return isTeacher;
    }

    public void setTeacher(boolean teacher) {
        isTeacher = teacher;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    @Override
    public String toString()
    {
        return "User{" +
                "user_id=" + userId +
                ", user_name='" + username + '\'' +
                ", authority='" + isTeacher + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
