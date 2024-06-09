package com.kartheek.ecommerce.features.order.model;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OrderDTO {
    private Long orderId;
    private Long userId;
    private BigDecimal totalAmount;
    private Double orderTotalProducts;
    private List<OrderItemDTO> orderItems = new ArrayList<>();
    private ShippingAddressDTO shippingAddress;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Double getOrderTotalProducts() {
        return orderTotalProducts;
    }

    public void setOrderTotalProducts(Double orderTotalProducts) {
        this.orderTotalProducts = orderTotalProducts;
    }

    public List<OrderItemDTO> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemDTO> orderItems) {
        this.orderItems = orderItems;
    }

    public ShippingAddressDTO getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(ShippingAddressDTO shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
}
