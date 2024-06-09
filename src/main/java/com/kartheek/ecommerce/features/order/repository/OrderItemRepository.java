package com.kartheek.ecommerce.features.order.repository;



import com.kartheek.ecommerce.features.order.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
