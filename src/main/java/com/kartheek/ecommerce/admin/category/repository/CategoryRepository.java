package com.kartheek.ecommerce.admin.category.repository;

import com.kartheek.ecommerce.admin.category.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
