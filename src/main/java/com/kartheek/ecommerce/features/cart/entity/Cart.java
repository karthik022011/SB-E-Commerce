package com.kartheek.ecommerce.features.cart.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.kartheek.ecommerce.user.entity.RegisterUser;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    private double cartTotalPrice;
    private double cartTotalProducts;

    @OneToOne
    @JoinColumn(name = "user_id")
    private RegisterUser user;

    @OneToMany(mappedBy = "cart")
    private List<CartItem> cartItems = new ArrayList<>();

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }


    public double getCartTotalPrice() {
        return cartTotalPrice;
    }

    public void setCartTotalPrice(double cartTotalPrice) {
        this.cartTotalPrice = cartTotalPrice;
    }

    public double getCartTotalProducts() {
        return cartTotalProducts;
    }

    public void setCartTotalProducts(double cartTotalProducts) {
        this.cartTotalProducts = cartTotalProducts;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public RegisterUser getUser() {
        return user;
    }

    public void setUser(RegisterUser user) {
        this.user = user;
    }
}
