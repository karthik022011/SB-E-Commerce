package com.kartheek.ecommerce.features.order.model.request;

import com.kartheek.ecommerce.features.order.model.ShippingAddressDTO;

import java.util.List;

public class OrderReqDTO {
    private Long userId;
    private List<OrderItemReqDTO> orderItems;
    private ShippingAddressDTO shippingAddress;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<OrderItemReqDTO> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemReqDTO> orderItems) {
        this.orderItems = orderItems;
    }

    public ShippingAddressDTO getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(ShippingAddressDTO shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
}
