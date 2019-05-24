package proz.models;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import proz.database.daos.QuestionDao;
import proz.database.daos.TestDao;
import proz.database.models.Category;
import proz.database.models.Test;
import proz.utils.converters.TestConverter;
import proz.utils.exceptions.ApplicationException;

import java.util.List;

public class TestDataModel
{
    private static ObservableList<TestFxModel> tests = FXCollections.observableArrayList(); // LISTA TESTÓW Z DANEJ KATEGORII
    private static ObjectProperty<TestFxModel> test = new SimpleObjectProperty<>(); // ZAZNACZONY TEST
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
        List<Test> tests = testDao.queryForTestsFromCategory(categoryId);
        populateTests(tests);
    }

    public static void deleteTestsFromCategory(int categoryId) throws ApplicationException
    {
        TestDao testDao = new TestDao();
        testDao.deleteTestsFromCategory(categoryId);
        tests.clear();
    }

    public static void deleteTest(TestFxModel test) throws ApplicationException
    {
        TestDao testDao = new TestDao(); // nowy dao
        QuestionDao questionDao = new QuestionDao();
        questionDao.deleteQuestionsFromTest(test.getTestId());
        testDao.deleteById(Test.class, test.getTestId()); //usuniecie zaznaczonej odpowiedzi
        tests.remove(test);
        // załozenie bedzi wywolane tylko przy usuwaniu z gory, jednej odpowiedzi nie da sie usunąc
    }


    public static void saveTestInDataBase(String testName, Category category) throws ApplicationException
    {
        Test newTest = new Test(testName, category);
        testDao.createOrUpdateAndRefresh(newTest);
        tests.add(TestConverter.testToTestFx(newTest));
    }

    public static void updateTestInDataBase() throws ApplicationException
    {
        testDao.createOrUpdate(TestConverter.testFxToTest(TestDataModel.getTest()));
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

