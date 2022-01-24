package com.uniware.ecommerce.product.api.command;

import lombok.Data;

@Data
public class GetVehicleByIds extends AbstractCommand {
    private String articleCountry;
    private String countriesCarSelection;
    private String country;
    private TecArray<Long> carIds;
    private Integer provider;

    @Override
    public String getName() {
        return "getVehicleByIds3";
    }
}
