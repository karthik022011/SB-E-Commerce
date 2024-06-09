package com.kartheek.ecommerce.features.order.service;


import com.kartheek.ecommerce.admin.product.entity.Product;
import com.kartheek.ecommerce.admin.product.repository.ProductRepository;
import com.kartheek.ecommerce.features.order.entity.Order;
import com.kartheek.ecommerce.features.order.entity.OrderItem;
import com.kartheek.ecommerce.features.order.entity.ShippingAddress;
import com.kartheek.ecommerce.features.order.model.OrderDTO;
import com.kartheek.ecommerce.features.order.model.request.OrderItemReqDTO;
import com.kartheek.ecommerce.features.order.model.request.OrderReqDTO;
import com.kartheek.ecommerce.features.order.repository.OrderItemRepository;
import com.kartheek.ecommerce.features.order.repository.OrderRepository;
import com.kartheek.ecommerce.user.entity.RegisterUser;
import com.kartheek.ecommerce.user.repository.UserInfoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public String  createOrder(OrderReqDTO orderReqDTO) {
        Optional<RegisterUser> optionalRegisterUser = userInfoRepository.findById(orderReqDTO.getUserId());
        Order order = new Order();
       // order.setTotalAmount(0.0);
        order.setOrderTotalProducts(0);
        order.setUser(optionalRegisterUser.get());
        ShippingAddress shippingAddress = modelMapper.map(orderReqDTO.getShippingAddress(), ShippingAddress.class);
        order.setShippingAddress(shippingAddress);
        orderRepository.save(order);

        List<OrderItemReqDTO> orderItemDTOs = orderReqDTO.getOrderItems();
        List<OrderItem> orderItems = new ArrayList<>();
        for (OrderItemReqDTO orderItemDTO : orderItemDTOs) {
            OrderItem orderItem = new OrderItem();
            Optional<Product> optionalProduct = productRepository.findById(orderItemDTO.getProductId());
            orderItem.setProduct(optionalProduct.get());
            orderItem.setQuantity(orderItemDTO.getQuantity());
            orderItem.setOrder(order);
            orderItems.add(orderItem);
        }
        orderItemRepository.saveAll(orderItems);
        return "Order Placed";
    }


    @Override
    public List<OrderDTO>  getAllOrders(Long userId) {
      List<Order> orders =  orderRepository.findByUserUserId(userId);
        return orders.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private OrderDTO convertToDto(Order order) {
        return modelMapper.map(order, OrderDTO.class);
    }
}
