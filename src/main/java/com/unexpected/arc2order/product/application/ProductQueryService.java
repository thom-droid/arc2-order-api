package com.unexpected.arc2order.product.application;

import com.unexpected.arc2order.product.domain.Product;
import com.unexpected.arc2order.product.infrastructure.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProductQueryService {

    private final ProductRepository productRepository;

    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }
}
