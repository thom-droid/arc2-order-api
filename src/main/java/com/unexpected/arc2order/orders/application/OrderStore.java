package com.unexpected.arc2order.orders.application;

import com.unexpected.arc2order.orders.domain.Order;

import java.util.Optional;

/**
 * adaptor JPA/Spring
 *
 *
 */
public interface OrderStore {
    Optional<Order> findById(Long id);
    Order save(Order order);
}
