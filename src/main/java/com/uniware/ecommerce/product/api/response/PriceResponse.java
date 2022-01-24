package com.uniware.ecommerce.product.api.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PriceResponse {
    private String currencyCode;
    private String discountGroup;
    private Boolean isDiscount;
    private BigDecimal price;
    private Integer priceCents;
    private Integer kindOfPriceKey;
    private String kindOfPriceDescription;
    private Integer priceUnitKey;
    private String priceUnitDescription;
    private String quantityUnitKey;
    private String quantityUnitDescription;
    private Integer validDateFrom;
    private Integer validDateTo;
}
