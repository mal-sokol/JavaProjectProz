package proz.models;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import proz.database.daos.CategoryDao;
import proz.database.models.Category;
import proz.utils.converters.CategoryConverter;
import proz.utils.exceptions.ApplicationException;

import java.util.List;

public class CategoryDataModel
{
    private ObservableList<CategoryFxModel> categories = FXCollections.observableArrayList();
    private ObjectProperty<CategoryFxModel> category = new SimpleObjectProperty<>();

    private void populateCategories(List<Category> categories)
    {
        this.categories.clear();
        categories.forEach(category -> {
            CategoryFxModel categoryFx = CategoryConverter.categoryToCategoryFx(category);
            this.categories.add(categoryFx);
        });
    }
    public void fetchDataFromDataBase() throws ApplicationException
    {
        CategoryDao categoryDao = new CategoryDao();
        List<Category> categories = categoryDao.queryForAll(Category.class);
        populateCategories(categories);
    }

    public void deleteCategoryById()
    {
//        CategoryDao categoryDao = new CategoryDao(); // nowy dao
//        CategoryDao.deleteById(Category.class, category.getValue().getCategory())//usuniecie zaznaczonej odpowiedzi
        // fetchDataFromDataBase();
//        // załozenie bedzi wywolane tylko przy usuwaniu z gory, jednej odpowiedzi nie da sie usunąc
    }

    public void saveCategoryInDataBase(String categoryName)
    {
//        CategoryDao categoryDao = new CategoryDao(); // nowy dao
//        Category newCategory = new Category();
//        newCategory.setCategoryName(categoryName);
//        categoryDao.createOrUpdate(newCategory);
//        fetchDataFromDataBase();
    }

    public void updateCategoryInDataBase()
    {
//        CategoryDao categoryDao = new CategoryDao(); // nowy dao
//        Category updatedCategory = categoryDao.findById(Category.class, getCategory().getCategory());
//        updatedCategory.setCategory(getCategory().getCategory());
//        categoryDao.createOrUpdate(updatedCategory);
//        fetchDataFromDataBase();
    }

    public ObservableList<CategoryFxModel> getCategories()
    {
        return categories;
    }

    public void setCategories(ObservableList<CategoryFxModel> categories)
    {
        this.categories = categories;
    }

    public CategoryFxModel getCategory()
    {
        return category.get();
    }

    public ObjectProperty<CategoryFxModel> categoryProperty()
    {
        return category;
    }

    public void setCategory(CategoryFxModel category)
    {
        this.category.set(category);
    }
}
