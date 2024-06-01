package com.kartheek.ecommerce.admin.category.service;

import com.kartheek.ecommerce.admin.category.entity.Category;
import com.kartheek.ecommerce.admin.category.model.CategoryDTO;
import com.kartheek.ecommerce.admin.category.model.CategoryResDTO;

public interface CategoryService {
    CategoryDTO createCategory(CategoryDTO categoryDTO);

    CategoryDTO updateCategory(Category category, Long categoryId);

    String deleteCategory(Long categoryId);

    CategoryResDTO getAllCategories();
}
