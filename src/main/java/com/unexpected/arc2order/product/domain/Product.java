package com.unexpected.arc2order.product.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@Table(name = "products")
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(name = "name", nullable = false, length = Integer.MAX_VALUE)
    private String name;
    @NotNull
    @Column(name = "category_id", nullable = false)
    private Long categoryId;
    @NotNull
    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

}
