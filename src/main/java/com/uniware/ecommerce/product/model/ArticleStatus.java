package com.uniware.ecommerce.product.model;

import lombok.Data;

@Data
public class ArticleStatus {
    private Integer id;
    private String description;
    private Integer validFromDate;
}
