package com.unexpected.arc2order.orders.application;

import com.unexpected.arc2order.orders.domain.OrderItemEntity;
import com.unexpected.arc2order.orders.infrastructure.OrderItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderItemQueryService {

    private final OrderItemRepository orderItemRepository;

    public List<OrderItemEntity> findAllBYOrderId(Long orderId) {
        return orderItemRepository.findAllByOrderEntity_Id(orderId);
    }
}
