package proz.utils.converters;

import proz.database.models.Question;
import proz.models.QuestionFxModel;

public class QuestionConverter
{
    private QuestionConverter() {}

    public static QuestionFxModel questionToQuestionFx(Question question)
    {
        QuestionFxModel fxModel = new QuestionFxModel();
        fxModel.setQuestion(question.getQuestion());
        fxModel.setQuestionId(question.getQuestionId());
        fxModel.setTestId(TestConverter.testToTestFx(question.getTestId()));
        return fxModel;
    }

    public static Question questionFxToQuestion(QuestionFxModel fxModel)
    {
        Question question = new Question();
        question.setQuestion(fxModel.getQuestion());
        question.setTestId(TestConverter.testFxtoTest(fxModel.getTestId()));
        question.setQuestionId(fxModel.getQuestionId());
        return question;
    }
}
