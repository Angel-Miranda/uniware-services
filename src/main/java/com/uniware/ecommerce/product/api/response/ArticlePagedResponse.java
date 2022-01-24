package com.uniware.ecommerce.product.api.response;

import lombok.Data;

import java.util.List;

@Data
public class ArticlePagedResponse {
    private Integer totalMatchingArticles;
    private Integer maxAllowedPage;
    private List<ArticleResponse> articles;
}
