package com.uniware.ecommerce.product.api.command;

import lombok.Data;

@Data
public class GetVehicleIdsByCriteria extends AbstractCommand {
    private String carType;
    private String countriesCarSelection;
    private Long manuId;
    private Long modId;
    private Integer provider;

    @Override
    public String getName() {
        return "getVehicleIdsByCriteria";
    }
}
