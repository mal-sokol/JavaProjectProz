package proz.utils.converters;

import proz.database.models.Test;
import proz.models.TestFxModel;

public class TestConverter
{
    private TestConverter() {}

    public static TestFxModel testToTestFx(Test test)
    {
        TestFxModel testFxModel = new TestFxModel();
        testFxModel.setCategoryId(test.getCategory().getCategoryId());
        testFxModel.setTestId(test.getTestId());
        testFxModel.setTestName(test.getName());
        return testFxModel;
    }
}
