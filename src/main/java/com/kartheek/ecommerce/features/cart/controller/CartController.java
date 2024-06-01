package com.kartheek.ecommerce.features.cart.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @PostMapping("/add")
    public void addProductToCart(){

    }

    @PostMapping()
    public void getCartItems(){

    }

    @PostMapping("/update")
    public void updateCartItem(){

    }

    @PostMapping("/delete")
    public void deleteCartItem(){

    }
}
