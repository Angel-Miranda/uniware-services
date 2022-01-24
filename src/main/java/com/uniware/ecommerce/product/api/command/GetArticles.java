package com.uniware.ecommerce.product.api.command;

import lombok.Data;

@Data
public class GetArticles extends AbstractCommand {
    private String articleCountry;
    private Integer provider;
    private Integer searchType;
    private Integer perPage;
    private Integer page;
    private Boolean includeAll;

    @Override
    public String getName() {
        return "getArticles";
    }
}
