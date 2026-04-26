package com.unexpected.arc2order.orders.api.response;

import com.unexpected.arc2order.orders.domain.Order;
import com.unexpected.arc2order.orders.domain.OrderEntity;

import java.time.LocalDateTime;

public record OrderStatusUpdateResponse(Long orderId,
                                        String status,
                                        LocalDateTime updatedAt) {
    public static OrderStatusUpdateResponse from(OrderEntity orderEntity) {
        return new OrderStatusUpdateResponse(orderEntity.getId(),
                orderEntity.getStatus().name(),
                orderEntity.getUpdatedAt());
    }

    public static OrderStatusUpdateResponse from(Order order) {
        return new OrderStatusUpdateResponse(order.getId(),
                order.getStatus().name(),
                order.getUpdatedAt());
    }

}
