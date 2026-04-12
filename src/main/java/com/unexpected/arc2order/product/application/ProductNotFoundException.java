package com.unexpected.arc2order.product.application;

import java.util.List;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(Long productId) {
        super(String.format("Product with id %s not found", productId));
    }

    public ProductNotFoundException(List<Long> productIds) {
        super(String.format("Product with id %s not found", productIds));
    }
}
