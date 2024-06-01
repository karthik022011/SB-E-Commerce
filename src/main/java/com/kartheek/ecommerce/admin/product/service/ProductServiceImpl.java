package com.kartheek.ecommerce.admin.product.service;

import com.kartheek.ecommerce.admin.category.entity.Category;
import com.kartheek.ecommerce.admin.category.repository.CategoryRepository;
import com.kartheek.ecommerce.admin.product.entity.Product;
import com.kartheek.ecommerce.admin.product.model.ProductDTO;
import com.kartheek.ecommerce.admin.product.model.ProductResDTO;
import com.kartheek.ecommerce.admin.product.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        Optional<Category> category = categoryRepository.findById(productDTO.getCategoryId());
        Product product = modelMapper.map(productDTO, Product.class);
        product.setCategory(category.get());
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
    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        Type listType = new TypeToken<List<ProductDTO>>(){}.getType();
        return modelMapper.map(products, listType);
    }

    @Override
    public List<ProductDTO> getProductsByCategory(Long categoryId) {
        List<Product> products = productRepository.findByCategoryIdCustomQuery(categoryId);
        Type listType = new TypeToken<List<ProductDTO>>(){}.getType();
        return modelMapper.map(products, listType);
    }

}
