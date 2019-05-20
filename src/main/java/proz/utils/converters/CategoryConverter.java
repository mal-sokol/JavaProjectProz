package proz.utils.converters;

import proz.database.models.Category;
import proz.models.CategoryFxModel;
import proz.database.models.Category;

public class CategoryConverter
{
    private CategoryConverter() {}

    public static CategoryFxModel categoryToCategoryFx(Category category)
    {
        CategoryFxModel categoryFx = new CategoryFxModel();
        categoryFx.setCategoryName(category.getName());
        categoryFx.setCategoryId(category.getCategoryId());
        return categoryFx;
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
