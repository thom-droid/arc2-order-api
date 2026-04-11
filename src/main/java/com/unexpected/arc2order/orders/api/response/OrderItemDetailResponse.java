package com.unexpected.arc2order.orders.api.response;

import com.unexpected.arc2order.orders.domain.OrderItemEntity;

import java.math.BigDecimal;

public record OrderItemDetailResponse(Long id,
                                      Long productId,
                                      BigDecimal unitPrice,
                                      Integer quantity) {
    public static OrderItemDetailResponse from(OrderItemEntity orderItem) {
        return new OrderItemDetailResponse(
                orderItem.getId(),
                orderItem.getProductId(),
                orderItem.getUnitPrice(),
                orderItem.getQuantity()
        );
    }
}
