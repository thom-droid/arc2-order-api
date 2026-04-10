package com.unexpected.arc2order.domain.orders;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class OrderService {

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