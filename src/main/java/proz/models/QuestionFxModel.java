package proz.models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class QuestionFxModel
{
    private IntegerProperty questionId = new SimpleIntegerProperty();
    private IntegerProperty testId = new SimpleIntegerProperty();
    private StringProperty question = new SimpleStringProperty();

    public int getQuestionId()
    {
        return questionId.get();
    }

    public IntegerProperty questionIdProperty()
    {
        return questionId;
    }

    public void setQuestionId(int questionId)
    {
        this.questionId.set(questionId);
    }

    public int getTestId()
    {
        return testId.get();
    }

    public IntegerProperty testIdProperty()
    {
        return testId;
    }

    public void setTestId(int testId)
    {
        this.testId.set(testId);
    }

    public String getQuestion()
    {
        return question.get();
    }

    public StringProperty questionProperty()
    {
        return question;
    }

    public void setQuestion(String question)
    {
        this.question.set(question);
    }
}
