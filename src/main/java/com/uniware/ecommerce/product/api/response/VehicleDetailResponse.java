package com.uniware.ecommerce.product.api.response;

import lombok.Data;

@Data
public class VehicleDetailResponse {
    private Integer carId;
    private Integer ccmTech;
    private String constructionType;
    private Integer cylinder;
    private Integer cylinderCapacityCcm;
    private Integer cylinderCapacityLiter;
    private String fuelType;
    private String fuelTypeProcess;
    private String impulsionType;
    private Integer manuId;
    private String manuName;
    private Integer modId;
    private String modelName;
    private String motorType;
    private Integer powerHpFrom;
    private Integer powerHpTo;
    private Integer powerKwFrom;
    private Integer powerKwTo;
    private String typeName;
    private Integer typeNumber;
    private Integer valves;
    private Integer yearOfConstrFrom;
    private Integer yearOfConstrTo;
    private Integer rmiTypeId;
}
