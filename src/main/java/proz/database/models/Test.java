package proz.database.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "TEST")
public class Test implements BaseModel
{
    public Test() {}

    @DatabaseField(generatedId = true, columnName = "TEST_ID")
    private int testId;

    @DatabaseField(columnName = "TEST_NAME", canBeNull = false)
    private String name;

    @DatabaseField(foreign = true, columnName = "CATEGORY_ID", canBeNull = false, foreignAutoRefresh = true)
    private Category categoryId;

    public int getTestId()
    {
        return testId;
    }

    public void setTestId(int testId)
    {
        this.testId = testId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Category getCategoryId()
    {
        return categoryId;
    }

    public void setCategoryId(Category categoryId)
    {
        this.categoryId = categoryId;
    }

    @Override
    public String toString()
    {
        return "Test{" +
                "testId=" + testId +
                ", name='" + name + '\'' +
                ", categoryId=" + categoryId +
                '}';
    }
}
