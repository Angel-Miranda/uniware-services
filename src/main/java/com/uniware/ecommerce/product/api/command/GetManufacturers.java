package com.uniware.ecommerce.product.api.command;

import lombok.Data;

@Data
public class GetManufacturers extends AbstractCommand {
    private String country;
    private String linkingTargetType;
    private Integer provider;

    @Override
    public String getName() {
        return "getManufacturers";
    }
}
