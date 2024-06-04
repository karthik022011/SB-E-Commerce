package com.kartheek.ecommerce.features.order.entity;

import jakarta.persistence.*;

@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private Double orderTotalPrice;

    private int orderTotalItemsCount;
}
