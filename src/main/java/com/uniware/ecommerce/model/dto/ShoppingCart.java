package com.uniware.ecommerce.model.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class ShoppingCart implements Serializable {

    private Long id;
    private List<Product> products;
    private BigDecimal total;
}
