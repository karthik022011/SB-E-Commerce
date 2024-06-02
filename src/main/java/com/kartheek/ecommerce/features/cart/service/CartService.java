package com.kartheek.ecommerce.features.cart.service;


import com.kartheek.ecommerce.features.cart.model.CartDTO;

public interface CartService {
    CartDTO addProductToCart(Long cartId, Long productId, Integer quantity);

    String removeProductFromCart(Long cartId, Long productId);

    //getCart

    //checkOut
}
