package com.uniware.ecommerce.product.api.response;

import lombok.Data;

@Data
public class ArticleRefResponse {
    private String articleNumber;
    private Integer dataSupplierId;
    private Integer mfrId;
    private String mfrName;
    private Boolean matchesSearchQuery;
    private String referenceTypeKey;
    private String referenceTypeDescription;
}
