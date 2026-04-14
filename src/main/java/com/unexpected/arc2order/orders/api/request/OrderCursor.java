package com.unexpected.arc2order.orders.api.request;

import com.unexpected.arc2order.orders.application.exception.InvalidCursorException;

import java.time.LocalDateTime;
import java.util.Objects;

public record OrderCursor(LocalDateTime createdAt, Long orderId) {

    public static OrderCursor empty() {
        return new OrderCursor(null, null);
    }

    public static OrderCursor parse(String cursor) {
        if (Objects.isNull(cursor)) {
            return OrderCursor.empty();
        }

        String[] s = cursor.split("_");

        LocalDateTime cursorCreatedAt;
        Long cursorOrderId;

        if (s.length != 2) {
            throw new InvalidCursorException("Invalid cursor format");
        }

        try {
            cursorCreatedAt = LocalDateTime.parse(s[0]);
        } catch (Exception ex ) {
            throw new InvalidCursorException("Invalid cursor date: " + cursor);
        }

        try {
            cursorOrderId = Long.parseLong(s[1]);
        } catch (Exception ex ) {
            throw new InvalidCursorException("Invalid cursor order id: " + cursor);
        }

        return new OrderCursor(cursorCreatedAt, cursorOrderId);
    }

    public static String format(LocalDateTime createdAt, Long orderId) {
        Objects.requireNonNull(createdAt);
        Objects.requireNonNull(orderId);

        return createdAt + "_" + orderId;
    }
}


