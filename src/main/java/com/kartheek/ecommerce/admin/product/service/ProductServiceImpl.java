package com.kartheek.ecommerce.admin.product.service;

import com.kartheek.ecommerce.admin.product.entity.Product;
import com.kartheek.ecommerce.admin.product.model.ProductDTO;
import com.kartheek.ecommerce.admin.product.model.ProductResDTO;
import com.kartheek.ecommerce.admin.product.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = modelMapper.map(productDTO, Product.class);
        Product savedProduct = productRepository.save(product);
        return modelMapper.map(savedProduct, ProductDTO.class);
    }

    @Override
    public ProductDTO updateProduct(Product product, Long productId) {
        return null;
    }

    @Override
    public String deleteProduct(Long productId) {
        return null;
    }

    @Override
    public ProductResDTO getAllProducts() {
        return null;
    }
}
