package com.kartheek.ecommerce.admin.product.service;


import com.kartheek.ecommerce.admin.product.entity.Product;
import com.kartheek.ecommerce.admin.product.model.ProductDTO;
import com.kartheek.ecommerce.admin.product.model.ProductResDTO;

public interface ProductService {
    ProductDTO createProduct(ProductDTO productDTO);

    ProductDTO updateProduct(Product product, Long productId);

    String deleteProduct(Long productId);

    ProductResDTO getAllProducts();
}
