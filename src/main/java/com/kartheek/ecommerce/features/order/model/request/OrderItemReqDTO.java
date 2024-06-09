package com.kartheek.ecommerce.features.order.model.request;

import com.kartheek.ecommerce.features.order.model.OrderItemDTO;
import com.kartheek.ecommerce.features.order.model.ShippingAddressDTO;

import java.util.List;

public class OrderItemReqDTO {
    private Long productId;
    private int quantity;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
