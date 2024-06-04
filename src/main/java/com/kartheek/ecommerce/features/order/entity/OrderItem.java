package com.kartheek.ecommerce.features.order.entity;


import com.kartheek.ecommerce.admin.product.entity.Product;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "order_items")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderItemId;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    /*@ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "productId")
    private @NotNull Long productId;*/

    private Integer quantity;

    private double orderedProductPrice;

    public Long getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public double getOrderedProductPrice() {
        return orderedProductPrice;
    }

    public void setOrderedProductPrice(double orderedProductPrice) {
        this.orderedProductPrice = orderedProductPrice;
    }
}
