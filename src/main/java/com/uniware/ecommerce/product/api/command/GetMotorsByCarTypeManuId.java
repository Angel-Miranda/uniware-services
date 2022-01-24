package com.uniware.ecommerce.product.api.command;

import lombok.Data;

@Data
public class GetMotorsByCarTypeManuId extends AbstractCommand {
    private String carType;
    private String countriesCarSelection;
    private Integer manuId;
    private Integer provider;

    @Override
    public String getName() {
        return "getMotorsByCarTypeManuIdTerm2";
    }
}
