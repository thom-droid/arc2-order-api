package com.unexpected.arc2order.orders.application.exception;

public class OrderAlreadyShippedException extends RuntimeException {
    public OrderAlreadyShippedException() {
        super("Order %s has already been shipped");
    }
}
