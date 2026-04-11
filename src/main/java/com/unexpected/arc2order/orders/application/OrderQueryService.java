package com.unexpected.arc2order.orders.application;

import com.unexpected.arc2order.orders.api.response.OrderDetailResponse;
import com.unexpected.arc2order.orders.domain.OrderEntity;
import com.unexpected.arc2order.orders.domain.OrderItemEntity;
import com.unexpected.arc2order.orders.infrastructure.OrderItemRepository;
import com.unexpected.arc2order.orders.infrastructure.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderQueryService {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;

    public OrderDetailResponse getOrderById(Long orderId) {
        OrderEntity orderEntity = orderRepository.findById(orderId).orElseThrow(() -> new OrderNotFoundException(orderId));
        List<OrderItemEntity> orderItems = orderItemRepository.findAllByOrderEntity_Id(orderId);
        return OrderDetailResponse.from(orderEntity, orderItems);
    }

    public Page<OrderEntity> getOrders(Long customerId, String status, Pageable pageable) {
        if (customerId == null && status == null) {
            return orderRepository.findAll(pageable);
        }
        if (customerId == null) {
            return orderRepository.findAllByStatus(status, pageable);
        }
        if (status == null) {
            return orderRepository.findAllByCustomerId(customerId, pageable);
        }
        return orderRepository.findAllByCustomerIdAndStatus(customerId, status, pageable);
    }
}