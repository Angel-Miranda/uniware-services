package com.uniware.ecommerce.product.api.response;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class ArticleResponse {
    private Long dataSupplierId;
    private String articleNumber;
    private Long mfrId;
    private String mfrName;
    private MiscArticleDataResponse misc;
    private List<GenericArticleResponse> genericArticles;
    private List<ArticleTextResponse> articleText;
    private List<String> gtins;
    private List<String> tradeNumbers;
    private List<OemNumberResponse> oemNumbers;
    private List<ArticleRefResponse> replacesArticles;
    private List<ArticleRefResponse> replacedByArticles;
    private List<CriteriaResponse> articleCriteria;
    private List<ArticleLinkageResponse> linkages;
    private List<PdfResponse> pdfs;
    private List<ImageResponse> images;
    private List<ArticleRefResponse> comparableNumbers;
    private List<LinkResponse> links;
    private Integer totalLinkages;
    private List<PriceResponse> prices;
    private List<CriteriaResponse> articleLogisticsCriteria;
}
