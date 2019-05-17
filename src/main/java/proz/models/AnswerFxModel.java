package proz.models;

import javafx.beans.property.*;

public class AnswerFxModel
{
    private IntegerProperty answerId = new SimpleIntegerProperty();
    private ObjectProperty<QuestionFxModel> questionId = new SimpleObjectProperty<>();
    private StringProperty answer = new SimpleStringProperty();
    private BooleanProperty isCorrect = new SimpleBooleanProperty();

    public int getAnswerId() { return answerId.get(); }

    public IntegerProperty answerIdProperty() { return answerId; }

    public void setAnswerId(int answerId) { this.answerId.set(answerId); }

    public QuestionFxModel getQuestionId() { return questionId.get(); }

    public ObjectProperty<QuestionFxModel> questionIdProperty() { return questionId; }

    public void setQuestionId(QuestionFxModel questionId) { this.questionId.set(questionId); }

    public String getAnswer() {
        return answer.get();
    }

    public StringProperty answerProperty() {
        return answer;
    }

    public void setAnswer(String answer)
    {
        this.answer.set(answer);
    }

    public boolean isIsCorrect()
    {
        return isCorrect.get();
    }

    public BooleanProperty isCorrectProperty()
    {
        return isCorrect;
    }

    public void setIsCorrect(boolean isCorrect)
    {
        this.isCorrect.set(isCorrect);
    }
}
