package com.kartheek.ecommerce.features.cart.controller;

import com.kartheek.ecommerce.features.cart.model.request.AddToCartReqDTO;
import com.kartheek.ecommerce.features.cart.model.CartDTO;
import com.kartheek.ecommerce.features.cart.service.CartService;
import com.kartheek.ecommerce.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/create/{userId}")
    public void createCart(@PathVariable Long userId){
        cartService.createCart(userId);
    }

    @PostMapping("/product/add")
    public void addProductToCart(@RequestBody AddToCartReqDTO addToCartReqDTO){
      String cartItem =  cartService.addProductToCart(addToCartReqDTO);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<ApiResponse<CartDTO>> getCart(@PathVariable Long userId) {
        CartDTO addresses = cartService.getCart(userId);
        ApiResponse<CartDTO> response = new ApiResponse<>();
        response.setStatus(HttpStatus.OK.value());
        response.setSuccess(true);
        response.setMessage("Succeeded");
        response.setData(addresses);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/product/delete")
    public void deleteCartItem(){

    }
}
