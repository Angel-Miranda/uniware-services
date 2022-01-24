package com.uniware.ecommerce.product.model;

import lombok.Data;

import java.util.List;

@Data
public class Page<T> {
    private Integer total;
    private Integer totalPages;
    private List<T> items;
}
