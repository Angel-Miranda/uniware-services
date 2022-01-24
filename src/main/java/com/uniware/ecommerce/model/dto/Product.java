package com.uniware.ecommerce.model.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Product {
    private String sku;
    private String description;
    private Integer quantity;
    private BigDecimal price;
    private BigDecimal total;
}
