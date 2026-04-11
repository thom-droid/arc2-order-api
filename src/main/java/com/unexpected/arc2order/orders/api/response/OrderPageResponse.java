package com.unexpected.arc2order.orders.api.response;

import com.unexpected.arc2order.orders.domain.OrderEntity;
import org.springframework.data.domain.Page;

import java.util.List;

public record OrderPageResponse(
        List<OrderSummaryResponse> items,
        int page,
        int size,
        boolean hasNext
) {
    public static OrderPageResponse from(Page<OrderEntity> page) {
        return new OrderPageResponse(page.stream().map(OrderSummaryResponse::from).toList(),
                page.getNumber(),
                page.getSize(),
                page.hasNext());
    }
}
