package com.unexpected.arc2order.orders.application.exception;

public class InvalidOrderStatusException extends RuntimeException {
    public InvalidOrderStatusException(Long orderId) {
        super(String.format("Order %s has to be created before cancellation", orderId));
    }
}
