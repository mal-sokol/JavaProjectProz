package proz.models;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import proz.database.daos.TestDao;
import proz.database.models.Test;
import proz.utils.converters.TestConverter;
import proz.utils.exceptions.ApplicationException;

import java.sql.SQLException;
import java.util.List;

public class TestDataModel
{
    private ObservableList<TestFxModel> tests = FXCollections.observableArrayList();
    private ObjectProperty<TestFxModel> test = new SimpleObjectProperty<>();

    private void populateTests(List<Test> tests)
    {
        this.tests.clear();
        tests.forEach(test -> {
            TestFxModel testFx = TestConverter.testToTestFx(test);
            this.tests.add(testFx);
        });
    }

    public void getTestsFromCategory(int categoryId) throws SQLException, ApplicationException {
        TestDao testDao = new TestDao();
        List<Test> tests = testDao.queryForTestsFromCategory(categoryId);
        populateTests(tests);
    }

    public ObservableList<TestFxModel> getTests()
    {
        return tests;
    }

    public void setTests(ObservableList<TestFxModel> tests)
    {
        this.tests = tests;
    }

    public TestFxModel getTest()
    {
        return test.get();
    }

    public ObjectProperty<TestFxModel> testProperty()
    {
        return test;
    }

    public void setTest(TestFxModel test)
    {
        this.test.set(test);
    }
}
