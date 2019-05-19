package proz.utils.converters;

import proz.database.models.Answer;
import proz.models.AnswerFxModel;

public class AnswerConverter
{
    private AnswerConverter() {}

    public static AnswerFxModel answerToAnswerFx(Answer answer)
    {
        AnswerFxModel fxModel = new AnswerFxModel();
        fxModel.setAnswer(answer.getAnswer());
        fxModel.setAnswerId(answer.getAnswerId());
        fxModel.setIsCorrect(answer.isCorrect());
        fxModel.setQuestionId(QuestionConverter.questionToQuestionFx(answer.getQuestionId()));
        return fxModel;
    }

    public static Answer answerFxToAnswer(AnswerFxModel fxModel)
    {
        Answer answer = new Answer();
        answer.setAnswer(fxModel.getAnswer());
        answer.setAnswerId(fxModel.getAnswerId());
        answer.setCorrect(fxModel.isIsCorrect());
        answer.setQuestionId(QuestionConverter.questionFxToQuestion(fxModel.getQuestionId()));
        return answer;
    }
}
