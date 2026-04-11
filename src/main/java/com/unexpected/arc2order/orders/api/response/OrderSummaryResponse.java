package com.unexpected.arc2order.orders.api.response;

import com.unexpected.arc2order.orders.domain.OrderEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record OrderSummaryResponse(Long orderId,
                                   Long customerId,
                                   String status,
                                   LocalDateTime createdAt,
                                   BigDecimal totalAmount) {

    public static OrderSummaryResponse from(OrderEntity orderEntity) {
        return new OrderSummaryResponse(
                orderEntity.getId(),
                orderEntity.getCustomerId(),
                orderEntity.getStatus(),
                orderEntity.getCreatedAt(),
                orderEntity.getAmount()
        );
    }
}
