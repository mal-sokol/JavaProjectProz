package proz.models;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import proz.database.daos.TestDao;
import proz.database.models.Category;
import proz.database.models.Test;
import proz.utils.converters.TestConverter;
import proz.utils.exceptions.ApplicationException;

import java.util.List;

public class TestDataModel
{
    private static ObservableList<TestFxModel> tests = FXCollections.observableArrayList();
    private static ObjectProperty<TestFxModel> test = new SimpleObjectProperty<>();
    private static TestDao testDao = new TestDao();

    private TestDataModel() {}

    private static void populateTests(List<Test> testList)
    {
        tests.clear();
        testList.forEach(test -> {
            TestFxModel testFx = TestConverter.testToTestFx(test);
            tests.add(testFx);
        });
    }

    public static void getTestsFromCategory(int categoryId) throws ApplicationException
    {
        List<Test> tests = testDao.queryForTestsFromCategory(testDao, categoryId);
        populateTests(tests);
    }

    public static Test saveTestInDataBase(String testName, Category category) throws ApplicationException
    {
        Test newTest = new Test();
        newTest.setName(testName);
        newTest.setCategory(category);
        testDao.createOrUpdate(newTest);
        TestDataModel.getTestDao().refresh(newTest);
        getTestsFromCategory(category.getCategoryId());
        return newTest;
    }

    public static ObservableList<TestFxModel> getTests()
    {
        return tests;
    }

    public static void setTests(ObservableList<TestFxModel> tests)
    {
        TestDataModel.tests = tests;
    }

    public static TestFxModel getTest()
    {
        return test.get();
    }

    public static ObjectProperty<TestFxModel> testProperty()
    {
        return test;
    }

    public static void setTest(TestFxModel test)
    {
        TestDataModel.test.set(test);
    }

    public static TestDao getTestDao()
    {
        return testDao;
    }
}
