package com.unexpected.arc2order.orders.application.exception;

public class OrderAlreadyConfirmedException extends RuntimeException {
    public OrderAlreadyConfirmedException(Long orderId) {
        super(String.format("Order %s has already been confirmed", orderId));
    }
}
