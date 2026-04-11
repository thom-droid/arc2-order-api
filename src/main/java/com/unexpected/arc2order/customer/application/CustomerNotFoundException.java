package com.unexpected.arc2order.customer.application;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(Long customerId) {
        super(String.format("Customer with id %s not found", customerId));
    }
}
