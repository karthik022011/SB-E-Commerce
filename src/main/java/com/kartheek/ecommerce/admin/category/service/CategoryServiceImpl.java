package com.kartheek.ecommerce.admin.category.service;

import com.kartheek.ecommerce.admin.category.entity.Category;
import com.kartheek.ecommerce.admin.category.model.CategoryDTO;
import com.kartheek.ecommerce.admin.category.model.CategoryResDTO;
import com.kartheek.ecommerce.admin.category.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category = modelMapper.map(categoryDTO, Category.class);
        Category savedCategory = categoryRepository.save(category);
        return modelMapper.map(savedCategory, CategoryDTO.class);
    }

    @Override
    public CategoryDTO updateCategory(Category category, Long categoryId) {
        return null;
    }

    @Override
    public String deleteCategory(Long categoryId) {
        return null;
    }

    @Override
    public CategoryResDTO getAllCategories() {
        return null;
    }
}
