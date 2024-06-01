package com.kartheek.ecommerce.admin.category.controller;


import com.kartheek.ecommerce.admin.category.model.CategoryDTO;
import com.kartheek.ecommerce.admin.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/admin/category/add")
    public ResponseEntity<CategoryDTO>  addCategory(@RequestBody CategoryDTO categoryDTO){
        CategoryDTO savedCategory = categoryService.createCategory(categoryDTO);
        return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
    }


    //Can access both admin and user
    @PostMapping("/categories")
    public void getAllCategories(){

    }

    @PostMapping("/admin/category/update")
    public void updateCategory(){

    }

    @PostMapping("/admin/category/delete")
    public void deleteCategory(){

    }
}
