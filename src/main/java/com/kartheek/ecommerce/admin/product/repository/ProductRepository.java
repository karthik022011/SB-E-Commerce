package com.kartheek.ecommerce.admin.product.repository;


import com.kartheek.ecommerce.admin.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p WHERE p.category.id = :categoryId")
    List<Product> findByCategoryIdCustomQuery(Long categoryId);
}
