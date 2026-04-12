package com.unexpected.arc2order.orders.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "order_idempotency",
        uniqueConstraints = {@UniqueConstraint(
                name = "order_idempotency_idempotency_key_key",
                columnNames = {"idempotency_key"})})
public class OrderIdempotency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 100)
    @NotNull
    @Column(name = "idempotency_key", nullable = false, length = 100)
    private String idempotencyKey;

    @Size(max = 255)
    @NotNull
    @Column(name = "request_hash", nullable = false)
    private String requestHash;

    @Column(name = "order_id")
    private Long orderId;

    @Size(max = 20)
    @NotNull
    @Column(name = "status", nullable = false, length = 20)
    private String status;

    @NotNull
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @NotNull
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    public static OrderIdempotency completed(String idempotencyKey, String requestHash, Long orderId) {
        LocalDateTime now = LocalDateTime.now();

        OrderIdempotency orderIdempotency = new OrderIdempotency();
        orderIdempotency.setIdempotencyKey(idempotencyKey);
        orderIdempotency.setRequestHash(requestHash);
        orderIdempotency.setOrderId(orderId);
        orderIdempotency.setStatus("COMPLETED");
        orderIdempotency.setCreatedAt(now);
        orderIdempotency.setUpdatedAt(now);
        return orderIdempotency;
    }
}
