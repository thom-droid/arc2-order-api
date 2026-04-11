package com.unexpected.arc2order.orders.api.response;

import com.unexpected.arc2order.orders.domain.OrderEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record CreateOrderResponse(Long orderId,
                                  Long customerId,
                                  String status,
                                  LocalDateTime createdAt,
                                  BigDecimal amount) {

    public static CreateOrderResponse from(OrderEntity order) {
        return new CreateOrderResponse(
                order.getId(),
                order.getCustomer().getId(),
                order.getStatus(),
                order.getCreatedAt(),
                order.getAmount()
        );
    }
}
