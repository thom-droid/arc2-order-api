package com.unexpected.arc2order.orders.infrastructure;

import com.unexpected.arc2order.orders.domain.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItemEntity, Long> {

    List<OrderItemEntity> findAllByOrderEntity_Id(Long orderId);
}
