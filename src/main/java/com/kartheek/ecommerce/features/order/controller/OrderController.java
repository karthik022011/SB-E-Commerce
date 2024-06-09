package com.kartheek.ecommerce.features.order.controller;


import com.kartheek.ecommerce.features.order.model.OrderDTO;
import com.kartheek.ecommerce.features.order.model.request.OrderReqDTO;
import com.kartheek.ecommerce.features.order.service.OrderService;
import com.kartheek.ecommerce.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/place")
    public ResponseEntity<ApiResponse<String>> placeOrder(@RequestBody OrderReqDTO orderReqDTO){
        String orderDTO = orderService.createOrder(orderReqDTO);
        ApiResponse<String> response = new ApiResponse<>();
        response.setStatus(HttpStatus.OK.value());
        response.setSuccess(true);
        response.setMessage("Succeeded");
        response.setData(orderDTO);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<ApiResponse<List<OrderDTO> >> getAllOrdersByUser(@PathVariable Long userId){
        List<OrderDTO> orderDTO = orderService.getAllOrders(userId);
        ApiResponse<List<OrderDTO> > response = new ApiResponse<>();
        response.setStatus(HttpStatus.OK.value());
        response.setSuccess(true);
        response.setMessage("Succeeded");
        response.setData(orderDTO);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
