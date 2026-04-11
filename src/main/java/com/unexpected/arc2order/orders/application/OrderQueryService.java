package com.unexpected.arc2order.orders.application;

import com.unexpected.arc2order.orders.infrastructure.OrderRepository;
import com.unexpected.arc2order.orders.domain.OrderEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class OrderQueryService {

    private final OrderRepository orderRepository;

    public OrderEntity getOrderById(Long orderId) {
        return orderRepository.findById(orderId).orElseThrow(NoSuchElementException::new);
    }

    public Page<OrderEntity> getOrders(Long customerId, String status, Pageable pageable) {
        if (customerId == null) {
            return orderRepository.findAll(pageable);
        } else if (status == null) {
            return orderRepository.findAllByCustomerId(customerId, pageable);
        }
        return orderRepository.findAllByCustomerIdAndStatus(customerId, status, pageable);
    }
}