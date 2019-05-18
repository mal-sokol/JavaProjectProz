package proz.models;

import com.j256.ormlite.stmt.QueryBuilder;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import proz.database.daos.TestDao;
import proz.database.models.Category;
import proz.database.models.Test;
import proz.utils.converters.TestConverter;
import proz.utils.exceptions.ApplicationException;

import java.sql.SQLException;
import java.util.List;

public class TestDataModel
{
    private ObservableList<TestFxModel> tests = FXCollections.observableArrayList();
    private ObjectProperty<TestFxModel> test = new SimpleObjectProperty<>();


    public void fetchTestsInCategory(Category category) throws ApplicationException, SQLException {
        TestDao testDao = new TestDao();
        QueryBuilder<Test, Integer> testQueryBuilder = testDao.getQueryBuilder(Test.class);
        List<Test> list = testQueryBuilder.where().eq("CATEGORY_ID", category).query();
        populateTests(list);
    }

    private void populateTests(List<Test> list)
    {
        tests.clear();
        list.forEach(test -> {
            TestFxModel testFx = TestConverter.testToTestFx(test);
            tests.add(testFx);
        });
    }

    public ObservableList<TestFxModel> getTests()
    {
        return tests;
    }


    public void setTests(ObservableList<TestFxModel> tests) {this.tests = tests;}
    public ObjectProperty<TestFxModel> testProperty() {return test;}
    
    public TestFxModel getTest() {return test.get();}
    public void setTest(TestFxModel test) {this.test.set(test);}
}
