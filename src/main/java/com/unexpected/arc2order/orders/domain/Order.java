package com.unexpected.arc2order.orders.domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * domain
 */
@Setter
@Getter
public class Order {
    private Long id;
    private OrderStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private BigDecimal amount;
    private Long customerId;

    public void confirm() {
        this.status = this.status.confirm();
        this.updatedAt = LocalDateTime.now();
    }

    public void cancel() {
        this.status = this.status.cancel();
        this.updatedAt = LocalDateTime.now();
    }
}
