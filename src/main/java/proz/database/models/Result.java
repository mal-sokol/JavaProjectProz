package proz.database.models;


import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

@DatabaseTable(tableName = "RESULT")
public class Result implements BaseModel
{
    public Result() {}

    @DatabaseField(generatedId = true, columnName = "RESULT_ID")
    private int resultId;

    @DatabaseField(columnName = "DATA", canBeNull = false)
    private Date date;

    @DatabaseField(columnName = "SCORE", canBeNull = false)
    private int score;

    @DatabaseField(columnName = "TEST_ID", foreign = true, canBeNull = false, foreignAutoRefresh = true)
    private Test testId;

    @DatabaseField(columnName = "USER_ID", foreign = true, canBeNull = false, foreignAutoRefresh = true)
    private User userId;

    public int getResultId()
    {
        return resultId;
    }

    public void setResultId(int resultId)
    {
        this.resultId = resultId;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public int getScore()
    {
        return score;
    }

    public void setScore(int score)
    {
        this.score = score;
    }

    public Test getTestId()
    {
        return testId;
    }

    public void setTestId(Test testId)
    {
        this.testId = testId;
    }

    public User getUserId()
    {
        return userId;
    }

    public void setUserId(User userId)
    {
        this.userId = userId;
    }

    @Override
    public String toString()
    {
        return "Result{" +
                "resultId=" + resultId +
                ", date=" + date +
                ", score=" + score +
                ", testId=" + testId +
                ", userId=" + userId +
                '}';
    }
}
