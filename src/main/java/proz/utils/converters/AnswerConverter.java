package proz.utils.converters;

import proz.database.daos.QuestionDao;
import proz.database.models.Answer;
import proz.database.models.Question;
import proz.models.AnswerFxModel;
import proz.utils.exceptions.ApplicationException;

import java.sql.SQLException;

public class AnswerConverter
{
    private AnswerConverter() {}

    public static AnswerFxModel answerToAnswerFx(Answer answer)
    {
        AnswerFxModel fxModel = new AnswerFxModel();
        fxModel.setAnswer(answer.getAnswer());
        fxModel.setAnswerId(answer.getAnswerId());
        fxModel.setIsCorrect(answer.isCorrect());
        fxModel.setQuestionId(answer.getQuestionId().getQuestionId();
        return fxModel;
    }

    public static Answer answerFxToAnswer(AnswerFxModel fxModel) throws ApplicationException, SQLException {
        Answer answer = new Answer();
        Question question = new Question();
        QuestionDao dao = new QuestionDao();
        answer.setAnswer(fxModel.getAnswer());
        answer.setAnswerId(fxModel.getAnswerId());
        answer.setCorrect(fxModel.isIsCorrect());
        question = dao.getQueryBuilder(Question.class).query().get(fxModel.getQuestionId());
        answer.setQuestionId(question);
        return answer;
    }
}
