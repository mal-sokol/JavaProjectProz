package proz.models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CategoryFxModel
{
    private StringProperty categoryName = new SimpleStringProperty();
    private IntegerProperty categoryId = new SimpleIntegerProperty();

    public String getCategoryName()
    {
        return categoryName.get();
    }

    public StringProperty categoryNameProperty()
    {
        return categoryName;
    }

    public void setCategoryName(String categoryName)
    {
        this.categoryName.set(categoryName);
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
