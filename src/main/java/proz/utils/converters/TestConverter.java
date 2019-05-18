package proz.utils.converters;

import proz.database.models.Test;
import proz.models.TestFxModel;

public class TestConverter
{
    private TestConverter() {}

    public static TestFxModel testToTestFx(Test test)
    {
        TestFxModel fxModel = new TestFxModel();
        fxModel.setTestId(test.getTestId());
        fxModel.setTestName(test.getName());
        fxModel.setCategoryId(CategoryConverter.categoryToCategoryFx(test.getCategoryId()));
        return fxModel;
    }

    public static Test testFxtoTest(TestFxModel fxModel)
    {
        Test test = new Test();
        test.setTestId(fxModel.getTestId());
        test.setCategoryId(CategoryConverter.categoryFxToCategory(fxModel.getCategoryId()));
        return test;
    }
}
