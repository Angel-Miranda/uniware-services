package com.uniware.ecommerce.product.api.response;

import lombok.Data;

@Data
public class ModelResponse {
    private Long modelId;
    private String modelname;
    private Integer yearOfConstrFrom;
    private Integer yearOfConstrTo;
}
