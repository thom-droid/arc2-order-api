package com.unexpected.arc2order.orders.api.response;

import com.unexpected.arc2order.orders.domain.OrderEntity;
import com.unexpected.arc2order.orders.domain.OrderItemEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record OrderDetailResponse(Long orderId,
                                  Long customerId,
                                  String status,
                                  LocalDateTime createdAt,
                                  BigDecimal totalAmount,
                                  List<OrderItemDetailResponse> orderItems) {

    public static OrderDetailResponse from(OrderEntity orderEntity, List<OrderItemEntity> orderItems) {
        return new OrderDetailResponse(
                orderEntity.getId(),
                orderEntity.getCustomer().getId(),
                orderEntity.getStatus(),
                orderEntity.getCreatedAt(),
                orderEntity.getAmount(),
                orderItems.stream().map(OrderItemDetailResponse::from).toList()
        );
    }
}

