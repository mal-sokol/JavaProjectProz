package proz.database.models;


import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "ANSWERS")
public class Answer implements BaseModel
{
    public Answer() {}

    public Answer(String answer, boolean isCorrect, Question question)
    {
        this.answer = answer;
        this.isCorrect = isCorrect;
        this.questionId = question;
    }

    @DatabaseField(generatedId = true, columnName = "ANSWER_ID")
    private int answerId;

    @DatabaseField(columnName = "ANSWER", canBeNull = false)
    private String answer;

    @DatabaseField(columnName = "CORRECT", canBeNull = false)
    private boolean isCorrect;

    @DatabaseField(columnName = "QUESTION_ID", foreign = true, canBeNull = false, foreignAutoRefresh = true)
    private Question questionId;

    public int getAnswerId()
    {
        return answerId;
    }

    public void setAnswerId(int answerId)
    {
        this.answerId = answerId;
    }

    public String getAnswer()
    {
        return answer;
    }

    public void setAnswer(String answer)
    {
        this.answer = answer;
    }

    public boolean isCorrect()
    {
        return isCorrect;
    }

    public void setCorrect(boolean correct)
    {
        isCorrect = correct;
    }

    public Question getQuestionId()
    {
        return questionId;
    }

    public void setQuestionId(Question questionId)
    {
        this.questionId = questionId;
    }

    @Override
    public String toString()
    {
        return "Answer{" +
                "answerId=" + answerId +
                ", answer='" + answer + '\'' +
                ", isCorrect='" + isCorrect + '\'' +
                ", questionId=" + questionId +
                '}';
    }
}
