package com.kartheek.ecommerce.features.order.service;


import com.kartheek.ecommerce.features.order.model.OrderDTO;
import com.kartheek.ecommerce.features.order.model.request.OrderReqDTO;

import java.util.List;


public interface OrderService {
    String createOrder(OrderReqDTO orderReqDTO);
    List<OrderDTO> getAllOrders(Long userId);
}
