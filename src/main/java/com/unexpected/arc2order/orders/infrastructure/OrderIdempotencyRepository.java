package com.unexpected.arc2order.orders.infrastructure;

import com.unexpected.arc2order.orders.domain.OrderIdempotency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderIdempotencyRepository extends JpaRepository<OrderIdempotency, Long> {

    Optional<OrderIdempotency> findByIdempotencyKey(String idempotencyKey);
}
