package com.unexpected.arc2order.orders.api.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CreateOrderItemRequest(@NotNull Long productId,
                                     @Positive Integer quantity) {

}
