package com.unexpected.arc2order.orders.api.response;

import com.unexpected.arc2order.orders.domain.OrderEntity;

import java.util.List;

public record OrderPageByCursorResponse(
        List<OrderSummaryByCursorResponse> items,
        boolean hasNext,
        String nextCursor
) {
    public static OrderPageByCursorResponse from(List<OrderEntity> data, boolean hasNext, String nextCursor) {

        return new OrderPageByCursorResponse(
                data.stream().map(OrderSummaryByCursorResponse::from).toList(),
                hasNext,
                nextCursor);
    }

}
