package com.uniware.ecommerce.product.api.response;

import lombok.Data;

@Data
public class LinkageTextResponse {
    private Integer informationTypeKey;
    private String informationTypeDescription;
    private Boolean isImmediateDisplay;
    private String text;
}
