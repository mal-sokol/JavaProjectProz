package proz.models;

import javafx.beans.property.*;
import java.util.Date;

public class ResultFxModel
{
    private IntegerProperty resultId = new SimpleIntegerProperty();
    private ObjectProperty<Date> date = new SimpleObjectProperty<>();
    private IntegerProperty score = new SimpleIntegerProperty();
    private ObjectProperty<UserFxModel> userId = new SimpleObjectProperty<>();
    private ObjectProperty<TestFxModel> testId = new SimpleObjectProperty<>();

    public int getResultId()
    {
        return resultId.get();
    }

    public IntegerProperty resultIdProperty()
    {
        return resultId;
    }

    public void setResultId(int resultId)
    {
        this.resultId.set(resultId);
    }

    public Date getDate()
    {
        return date.get();
    }

    public ObjectProperty<Date> dateProperty()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date.set(date);
    }

    public int getScore()
    {
        return score.get();
    }

    public IntegerProperty scoreProperty()
    {
        return score;
    }

    public void setScore(int score)
    {
        this.score.set(score);
    }

    public UserFxModel getUserId()
    {
        return userId.get();
    }

    public ObjectProperty<UserFxModel> userIdProperty()
    {
        return userId;
    }

    public void setUserId(UserFxModel userId)
    {
        this.userId.set(userId);
    }

    public TestFxModel getTestId()
    {
        return testId.get();
    }

    public ObjectProperty<TestFxModel> testIdProperty()
    {
        return testId;
    }

    public void setTestId(TestFxModel testId)
    {
        this.testId.set(testId);
    }
}
