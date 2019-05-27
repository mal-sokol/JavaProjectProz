package proz.models;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import proz.database.daos.ResultDao;
import proz.database.models.Result;
import proz.database.models.Test;
import proz.database.models.User;
import proz.utils.converters.ResultConverter;
import proz.utils.exceptions.ApplicationException;

import java.util.List;

public class ResultDataModel
{
    private static ObservableList<ResultFxModel> results = FXCollections.observableArrayList();
    private static ObjectProperty<ResultFxModel> result = new SimpleObjectProperty<>();
    private static ResultDao resultDao = new ResultDao();

    private ResultDataModel() {}

    private static void populateResults(List<Result> resultList)
    {
        results.clear();
        resultList.forEach(result -> {
            ResultFxModel resultFx = ResultConverter.resultToResultFx(result);
            results.add(resultFx);
        });
    }

    public static void saveResultInDataBase(int score, Test test, User user) throws ApplicationException
    {
        resultDao.createOrUpdate(new Result(score, test, user));
    }
}
