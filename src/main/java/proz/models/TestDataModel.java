package proz.models;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import proz.database.daos.QuestionDao;
import proz.database.daos.TestDao;
import proz.database.models.Category;
<<<<<<< HEAD
import proz.database.models.Question;
=======
>>>>>>> dynovzy-master
import proz.database.models.Test;
import proz.utils.converters.TestConverter;
import proz.utils.exceptions.ApplicationException;

import java.util.List;

public class TestDataModel
{
<<<<<<< HEAD
    private static ObservableList<TestFxModel> tests = FXCollections.observableArrayList();
    private static ObjectProperty<TestFxModel> test = new SimpleObjectProperty<>();
    private static ObjectProperty<CategoryFxModel> parentCategory = new SimpleObjectProperty<>();

=======
    private static ObservableList<TestFxModel> tests = FXCollections.observableArrayList(); // LISTA TESTÓW Z DANEJ KATEGORII
    private static ObjectProperty<TestFxModel> test = new SimpleObjectProperty<>(); // ZAZNACZONY TEST
    private static TestDao testDao = new TestDao();
>>>>>>> dynovzy-master

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
<<<<<<< HEAD
        TestDao testDao = new TestDao();
        List<Test> tests = testDao.queryForTestsFromCategory(categoryId);
        populateTests(tests);
    }

    public static void deleteTestsFromCategory(int categoryId) throws ApplicationException
    {
        TestDao testDao = new TestDao();
        testDao.deleteTestsFromCategory(categoryId);
        tests.clear();
    }

    public static void deleteTestById(int testId) throws ApplicationException
    {
        TestDao testDao = new TestDao(); // nowy dao
        QuestionDao questionDao = new QuestionDao();
        questionDao.deleteQuestionsFromTest(testId);
        testDao.deleteById(Test.class, testId); //usuniecie zaznaczonej odpowiedzi
        getTestsFromCategory(parentCategory.get().getCategoryId());
        // załozenie bedzi wywolane tylko przy usuwaniu z gory, jednej odpowiedzi nie da sie usunąc
    }
    
=======
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

>>>>>>> dynovzy-master
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

<<<<<<< HEAD


    public static CategoryFxModel getParentCategory() {
        return parentCategory.get();
    }

    public static ObjectProperty<CategoryFxModel> parentCategoryProperty() {
        return parentCategory;
    }

    public static void setParentCategory(CategoryFxModel parentCategory) {
        TestDataModel.parentCategory.set(parentCategory);
    }

=======
    public static TestDao getTestDao()
    {
        return testDao;
    }
>>>>>>> dynovzy-master
}

