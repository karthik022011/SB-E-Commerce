package com.kartheek.ecommerce.admin.product.repository;


import com.kartheek.ecommerce.admin.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
