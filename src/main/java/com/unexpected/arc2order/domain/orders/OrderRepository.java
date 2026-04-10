package com.unexpected.arc2order.domain.orders;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    Page<OrderEntity> findAllByCustomerId(Long customerId, Pageable pageable);
    Page<OrderEntity> findAllByCustomerIdAndStatus(Long customerId, String status, Pageable pageable);
}
