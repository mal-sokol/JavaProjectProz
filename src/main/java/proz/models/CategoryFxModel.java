package proz.models;

import javafx.beans.property.*;
import javafx.collections.ObservableList;

public class CategoryFxModel
{
    private StringProperty categoryName = new SimpleStringProperty();
    private IntegerProperty categoryId = new SimpleIntegerProperty();

    public CategoryFxModel(String categoryName, int categoryId, ObservableList<TestFxModel> listOfTests)
    {
        this.setCategoryName(categoryName);
        this.setCategoryId(categoryId);
    }

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
