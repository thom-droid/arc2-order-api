package com.unexpected.arc2order.orders.domain;

import com.unexpected.arc2order.orders.application.exception.InvalidOrderStatusException;
import com.unexpected.arc2order.orders.application.exception.OrderAlreadyCancelledException;
import com.unexpected.arc2order.orders.application.exception.OrderAlreadyConfirmedException;
import com.unexpected.arc2order.orders.application.exception.OrderAlreadyShippedException;

public enum OrderStatus {
    CREATED,
    CONFIRMED,
    CANCELLED,
    SHIPPED,
    ;

    public OrderStatus confirm() {
        if (this == CONFIRMED) {
            throw new OrderAlreadyConfirmedException();
        }
        if (this == CANCELLED) {
            throw new OrderAlreadyCancelledException();
        }
        if (this == SHIPPED) {
            throw new OrderAlreadyShippedException();
        }
        return CONFIRMED;
    }

    public OrderStatus cancel() {
        if (this == CANCELLED) {
            throw new OrderAlreadyCancelledException();
        }
        if (this == SHIPPED) {
            throw new OrderAlreadyShippedException();
        }
        if (this == CREATED) {
            throw new InvalidOrderStatusException();
        }
        return CANCELLED;
    }
}
