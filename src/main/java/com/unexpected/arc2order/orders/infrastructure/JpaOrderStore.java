package com.unexpected.arc2order.orders.infrastructure;

import com.unexpected.arc2order.orders.application.OrderStore;
import com.unexpected.arc2order.orders.domain.Order;
import com.unexpected.arc2order.orders.domain.OrderEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class JpaOrderStore implements OrderStore {

    private final OrderRepository orderRepository;

    @Override
    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id).map(OrderMapper::toDomain);
    }

    @Override
    public Order save(Order order) {
        OrderEntity entity = OrderMapper.toEntity(order);
        return OrderMapper.toDomain(orderRepository.save(entity));
    }

}
