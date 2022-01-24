package com.uniware.ecommerce.product.api.command;

import lombok.Data;

@Data
public class GetAmBrands extends AbstractCommand {
    private String articleCountry;
    private Integer provider;

    @Override
    public String getName() {
        return "getAmBrands";
    }
}
