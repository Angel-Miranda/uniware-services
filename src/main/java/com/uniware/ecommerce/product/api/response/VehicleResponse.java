package com.uniware.ecommerce.product.api.response;

import lombok.Data;

@Data
public class VehicleResponse {
    private Long carId;
    private VehicleDetailResponse vehicleDetails;
}
