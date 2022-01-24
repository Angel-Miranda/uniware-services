package com.uniware.ecommerce.product.model;

import lombok.Data;

@Data
public class Motor {
    private Manufacturer manufacturer;
    private Long id;
    private String code;

    private Integer cylinder;
    private Integer cylinderCapacity;
    private Integer powerHP;
    private Integer powerKW;
}
