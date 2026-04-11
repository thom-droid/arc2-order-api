package com.unexpected.arc2order.product.application;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(Long productId) {
        super(String.format("Product with id %s not found", productId));
    }
}
