package com.unexpected.arc2order.orders.api;

import com.unexpected.arc2order.orders.domain.OrderEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record OrderDetailResponse(Long orderId,
                                  Long customerId,
                                  String status,
                                  LocalDateTime createdAt,
                                  BigDecimal totalAmount) {

    public static OrderDetailResponse from(OrderEntity orderEntity) {
        return new OrderDetailResponse(
                orderEntity.getId(),
                orderEntity.getCustomerId(),
                orderEntity.getStatus(),
                orderEntity.getCreatedAt(),
                orderEntity.getAmount()
        );
    }
}

