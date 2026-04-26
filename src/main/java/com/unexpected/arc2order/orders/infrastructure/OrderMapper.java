package com.unexpected.arc2order.orders.infrastructure;

import com.unexpected.arc2order.orders.domain.Order;
import com.unexpected.arc2order.orders.domain.OrderEntity;

public final class OrderMapper {
    private OrderMapper() {
    }

    public static Order toDomain(OrderEntity orderEntity) {
        Order order = new Order();
        order.setId(orderEntity.getId());
        order.setStatus(orderEntity.getStatus());
        order.setAmount(orderEntity.getAmount());
        order.setCreatedAt(orderEntity.getCreatedAt());
        order.setUpdatedAt(orderEntity.getUpdatedAt());
        return order;
    }

    public static OrderEntity toEntity(Order order) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(order.getId());
        orderEntity.setStatus(order.getStatus());
        orderEntity.setAmount(order.getAmount());
        orderEntity.setCreatedAt(order.getCreatedAt());
        orderEntity.setUpdatedAt(order.getUpdatedAt());
        return orderEntity;
    }
}
