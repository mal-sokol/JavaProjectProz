package proz.utils.converters;

import proz.database.models.Question;
import proz.models.QuestionFxModel;

public class QuestionConverter
{
    private QuestionConverter() {}

    public static QuestionFxModel questionToQuestionFx(Question question)
    {
        QuestionFxModel fxModel = new QuestionFxModel();
        return fxModel;
    }

    public static Question questionFxToQuestion(QuestionFxModel fxModel)
    {
        Question question = new Question();
        return question;
    }
}
