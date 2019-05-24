package proz.utils.converters;

import proz.database.models.Test;
import proz.models.TestFxModel;

public class TestConverter
{
    private TestConverter() {}

//    public static TestFxModel testToTestFx(Test test)
//    {
//        TestFxModel testFxModel = new TestFxModel();
//        testFxModel.setCategoryId(test.getCategory().getCategoryId());
//        testFxModel.setTestId(test.getTestId());
//        testFxModel.setTestName(test.getName());
//        return testFxModel;
//    }

    public static TestFxModel testToTestFx(Test test)
    {
        TestFxModel fxModel = new TestFxModel();
        fxModel.setTestId(test.getTestId());
        fxModel.setTestName(test.getName());
        fxModel.setCategoryId(CategoryConverter.categoryToCategoryFx(test.getCategory()));
        return fxModel;
    }

    public static Test testFxToTest(TestFxModel fxModel)
    {
        Test test = new Test();
        test.setName(fxModel.getTestName());
        test.setTestId(fxModel.getTestId());
        test.setCategory(CategoryConverter.categoryFxToCategory(fxModel.getCategoryId()));
        return test;
    }


}
