package com.unexpected.arc2order.orders.application.exception;

public class OrderAlreadyShippedException extends RuntimeException {
    public OrderAlreadyShippedException(Long orderId) {
        super(String.format("Order %s has already been shipped", orderId));
    }
}
