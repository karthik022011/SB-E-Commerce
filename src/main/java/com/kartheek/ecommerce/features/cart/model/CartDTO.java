package com.kartheek.ecommerce.features.cart.model;

import java.util.ArrayList;
import java.util.List;

public class CartDTO {
    private Double cartTotalPrice;
    private Double cartTotalProducts;

    private List<CartItemDTO> cartItems = new ArrayList<>();

    public Double getCartTotalPrice() {
        return cartTotalPrice;
    }

    public void setCartTotalPrice(Double cartTotalPrice) {
        this.cartTotalPrice = cartTotalPrice;
    }

    public Double getCartTotalProducts() {
        return cartTotalProducts;
    }

    public void setCartTotalProducts(Double cartTotalProducts) {
        this.cartTotalProducts = cartTotalProducts;
    }

    public List<CartItemDTO> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItemDTO> cartItems) {
        this.cartItems = cartItems;
    }
}
