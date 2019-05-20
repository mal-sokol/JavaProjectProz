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
    private Category category;

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

    public Category getCategory()
    {
        return category;
    }

    public void setCategory(Category category)
    {
        this.category = category;
    }

    @Override
    public String toString()
    {
        return "Test{" +
                "testId=" + testId +
                ", name='" + name + '\'' +
                ", category=" + category +
                '}';
    }
}
