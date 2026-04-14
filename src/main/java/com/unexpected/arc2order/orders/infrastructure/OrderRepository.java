package com.unexpected.arc2order.orders.infrastructure;

import com.unexpected.arc2order.orders.domain.OrderEntity;
import com.unexpected.arc2order.orders.domain.OrderStatus;
import org.springframework.data.domain.Limit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    Page<OrderEntity> findAllByStatus(OrderStatus status, Pageable pageable);
    Page<OrderEntity> findAllByCustomerId(Long customerId, Pageable pageable);
    Page<OrderEntity> findAllByCustomerIdAndStatus(Long customer_id, OrderStatus status, Pageable pageable);


    @Query("""
                SELECT o
                FROM OrderEntity o
                WHERE (:status is null or o.status = :status)
                ORDER BY o.createdAt DESC, o.id DESC
            """)
    List<OrderEntity> findFirstPageByStatus(OrderStatus status, Pageable pageable);

    @Query("""
                SELECT o
                FROM OrderEntity o
                WHERE (
                      (o.createdAt < :cursorCreatedAt)
                      OR (o.createdAt = :cursorCreatedAt AND o.id < :cursorOrderId)
                )
                AND (:status is null or o.status = :status)
                ORDER BY o.createdAt DESC, o.id DESC
                LIMIT :pageSize
            """)
    List<OrderEntity> findPageByCursor(
            @Param("status") OrderStatus status,
            @Param("cursorCreatedAt") LocalDateTime cursorCreatedAt,
            @Param("cursorOrderId") Long cursorOrderId,
            Pageable pageable
    );

}
