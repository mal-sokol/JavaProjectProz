package proz.models;

import javafx.beans.property.*;

public class TestFxModel
{
    private StringProperty testName = new SimpleStringProperty();
    private IntegerProperty testId = new SimpleIntegerProperty();
    private IntegerProperty categoryId = new SimpleIntegerProperty();

    public String getTestName()
    {
        return testName.get();
    }

    public StringProperty testNameProperty()
    {
        return testName;
    }

    public void setTestName(String testName)
    {
        this.testName.set(testName);
    }

    public int getTestId()
    {
        return testId.get();
    }

    public IntegerProperty testIdProperty()
    {
        return testId;
    }

    public void setTestId(int testId)
    {
        this.testId.set(testId);
    }

    public int getCategoryId() {
        return categoryId.get();
    }

    public IntegerProperty categoryIdProperty() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId.set(categoryId);
    }
}
