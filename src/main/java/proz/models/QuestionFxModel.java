package proz.models;

import javafx.beans.property.*;

public class QuestionFxModel
{
    private IntegerProperty questionId = new SimpleIntegerProperty();
    private ObjectProperty<TestFxModel> testId = new SimpleObjectProperty<>();
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
