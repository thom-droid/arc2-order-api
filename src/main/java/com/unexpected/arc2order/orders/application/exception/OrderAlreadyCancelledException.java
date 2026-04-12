package com.unexpected.arc2order.orders.application.exception;

public class OrderAlreadyCancelledException extends RuntimeException {
    public OrderAlreadyCancelledException() {
        super("Order %s has already been cancelled");
    }
}
