package proz.utils.converters;

import proz.database.models.Category;
import proz.models.CategoryFxModel;

public class CategoryConverter
{
    private CategoryConverter() {}

    public static CategoryFxModel categoryToCategoryFx(Category category)
    {
        CategoryFxModel fxModel = new CategoryFxModel(category.getName(), category.getCategoryId(), null);
        return fxModel;
    }

    public static Category categoryFxToCategory(CategoryFxModel fxModel)
    {
        Category category = new Category();
        category.setName(fxModel.getCategoryName());
        category.setCategoryId(fxModel.getCategoryId());
//        category.setTests();
        return category;
    }
}
