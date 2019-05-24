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
    private static ObservableList<CategoryFxModel> categories = FXCollections.observableArrayList(); // LISTA WSZYSTKICH KATEGORII
    private static ObjectProperty<CategoryFxModel> category = new SimpleObjectProperty<>(); // KATEGORIA ZAZNACZONA W WIDOKU
    private static CategoryDao categoryDao = new CategoryDao();

    private CategoryDataModel() {}

    private static void populateCategories(List<Category> categoryList)
    {
        categories.clear();
        categoryList.forEach(category -> {
            CategoryFxModel categoryFx = CategoryConverter.categoryToCategoryFx(category);
            categories.add(categoryFx);
        });
    }
    public static void fetchDataFromDataBase() throws ApplicationException
    {
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

    public static void saveCategoryInDataBase(String categoryName) throws ApplicationException
    {
        Category newCategory = new Category(categoryName);
        categoryDao.createOrUpdateAndRefresh(newCategory);
        categories.add(CategoryConverter.categoryToCategoryFx(newCategory));
    }

    public static void updateCategoryInDataBase() throws ApplicationException
    {
        categoryDao.createOrUpdate(CategoryConverter.categoryFxToCategory(CategoryDataModel.getCategory()));
    }

    public static ObservableList<CategoryFxModel> getCategories()
    {
        return categories;
    }

    public static void setCategories(ObservableList<CategoryFxModel> categories)
    {
        CategoryDataModel.categories = categories;
    }

    public static CategoryFxModel getCategory()
    {
        return category.get();
    }

    public static ObjectProperty<CategoryFxModel> categoryProperty()
    {
        return category;
    }

    public static void setCategory(CategoryFxModel category)
    {
        CategoryDataModel.category.set(category);
    }

    public static CategoryDao getCategoryDao()
    {
        return categoryDao;
    }
}
