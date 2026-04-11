package com.unexpected.arc2order.orders.application;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(Long orderId) {
        super(String.format("Order with id %s not found", orderId));
    }
}
