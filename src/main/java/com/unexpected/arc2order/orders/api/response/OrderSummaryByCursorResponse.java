package com.unexpected.arc2order.orders.api.response;

import com.unexpected.arc2order.orders.domain.OrderEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record OrderSummaryByCursorResponse(
        Long id,
        String status,
        LocalDateTime createdAt,
        BigDecimal totalAmount
) {
    public static OrderSummaryByCursorResponse from(OrderEntity orderEntity) {
        return new OrderSummaryByCursorResponse(
                orderEntity.getId(),
                orderEntity.getStatus().name(),
                orderEntity.getCreatedAt(),
                orderEntity.getAmount()
        );
    }
}
