package com.uniware.ecommerce.product.api.response;

import lombok.Data;

@Data
public class GenericArticleResponse {
    private Integer genericArticleId;
    private String genericArticleDescription;
    private Integer legacyArticleId;
}
