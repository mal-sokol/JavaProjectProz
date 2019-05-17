package proz.database.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "QUESTION")
public class Question implements BaseModel
{
    public Question() {}

    @DatabaseField(generatedId = true, columnName = "QUESTION_ID")
    private int questionId;

    @DatabaseField(columnName = "QUESTION", canBeNull = false)
    private String question;

    @DatabaseField(columnName = "TEST_ID", foreign = true, canBeNull = false, foreignAutoRefresh = true)
    private Test testId;

    public int getQuestionId()
    {
        return questionId;
    }

    public void setQuestionId(int questionId)
    {
        this.questionId = questionId;
    }

    public String getQuestion()
    {
        return question;
    }

    public void setQuestion(String question)
    {
        this.question = question;
    }

    public Test getTestId()
    {
        return testId;
    }

    public void setTestId(Test testId)
    {
        this.testId = testId;
    }

    @Override
    public String toString()
    {
        return "Question{" +
                "questionId=" + questionId +
                ", question='" + question + '\'' +
                ", testId=" + testId +
                '}';
    }
}
