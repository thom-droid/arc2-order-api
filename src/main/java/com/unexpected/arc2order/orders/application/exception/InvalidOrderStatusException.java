package com.unexpected.arc2order.orders.application.exception;

public class InvalidOrderStatusException extends RuntimeException {
    public InvalidOrderStatusException() {
        super("Invalid Order Status");
    }
}
