package com.uniware.ecommerce.product.api.response;

import lombok.Data;

@Data
public class AssetResponse {
    private String fileName;
    private String typeDescription;
    private Integer typeKey;
    private String headerDescription;
    private Integer headerKey;
}
