package com.uniware.ecommerce.product.model;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class Article {
    private Long id;
    private String number;
    private Brand brand;
    private Misc misc;
    private List<GenericArticle> genericArticles;
    private List<Object> articleText;
    private List<String> gtins;
    private List<String> tradeNumbers;

    private List<Object> replacesArticles;
    private List<Object> replacedByArticles;

    private List<Object> linkages;
    private List<Object> pdfs;
    private List<ImageData> images;
    private List<Object> comparableNumbers;
    private List<Object> links;
    private Integer totalLinkages;
    private List<Object> prices;
    private List<Object> articleLogisticsCriteria;
}
