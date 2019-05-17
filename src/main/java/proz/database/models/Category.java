package proz.database.models;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "CATEGORY")
public class Category implements BaseModel
{

    public Category() {}

    @DatabaseField(generatedId = true, columnName = "CATEGORY_ID")
    private int categoryId;

    @DatabaseField(columnName = "CATEGORY_NAME", canBeNull = false)
    private String name;

    @ForeignCollectionField(columnName = "TEST_ID", eager = true)
    private ForeignCollection<Test> tests;

    public ForeignCollection<Test> getTests()
    {
        return tests;
    }

    public void setTests(ForeignCollection<Test> tests)
    {
        this.tests = tests;
    }

    public int getCategoryId()
    {
        return categoryId;
    }

    public void setCategoryId(int categoryId)
    {
        this.categoryId = categoryId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }


    @Override
    public String toString()
    {
        return "Category{" +
                "categoryId=" + categoryId +
                ", name='" + name + '\'' +
                ", tests=" + tests +
                '}';
    }
}
