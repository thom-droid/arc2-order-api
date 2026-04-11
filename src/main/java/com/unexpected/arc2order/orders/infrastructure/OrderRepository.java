package com.unexpected.arc2order.orders.infrastructure;

import com.unexpected.arc2order.orders.domain.OrderEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    Page<OrderEntity> findAllByStatus(String status, Pageable pageable);
    Page<OrderEntity> findAllByCustomerId(Long customerId, Pageable pageable);
    Page<OrderEntity> findAllByCustomerIdAndStatus(Long customerId, String status, Pageable pageable);
}
