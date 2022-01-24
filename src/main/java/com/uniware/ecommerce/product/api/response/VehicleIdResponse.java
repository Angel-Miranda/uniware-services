package com.uniware.ecommerce.product.api.response;

import lombok.Data;

@Data
public class VehicleIdResponse {
    private Long carId;
    private String carName;
    private String carType;
    private String firstCountry;
}
