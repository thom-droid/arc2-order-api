package com.unexpected.arc2order.orders.application.exception;

public class OrderAlreadyConfirmedException extends RuntimeException {
    public OrderAlreadyConfirmedException() {
        super("Order has already been confirmed");
    }
}
