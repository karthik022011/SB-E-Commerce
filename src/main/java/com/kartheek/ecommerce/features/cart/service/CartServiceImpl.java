package com.kartheek.ecommerce.features.cart.service;

import com.kartheek.ecommerce.features.cart.model.CartDTO;
import com.kartheek.ecommerce.features.cart.repository.CartRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CartRepository cartRepository;

    @Override
    public CartDTO addProductToCart(Long cartId, Long productId, Integer quantity) {
        return null;
    }

    @Override
    public String removeProductFromCart(Long cartId, Long productId) {
        return null;
    }
}
