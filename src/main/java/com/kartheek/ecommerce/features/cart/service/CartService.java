package com.kartheek.ecommerce.features.cart.service;


import com.kartheek.ecommerce.features.cart.model.request.AddToCartReqDTO;
import com.kartheek.ecommerce.features.cart.model.CartDTO;

public interface CartService {
    String addProductToCart(AddToCartReqDTO addToCartReqDTO);

    String removeProductFromCart(Long cartId, Long productId);

    CartDTO getCart(Long userId);

    String  createCart(Long userId);

    //checkOut
}
