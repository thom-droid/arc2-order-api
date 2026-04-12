package com.unexpected.arc2order.orders.application.exception;

public class OrderAlreadyCancelledException extends RuntimeException {
    public OrderAlreadyCancelledException(Long orderId) {
        super(String.format("Order %s has already been cancelled", orderId));
    }
}
