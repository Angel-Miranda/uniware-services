package com.uniware.ecommerce.product.api.response;

import lombok.Data;

@Data
public class MotorResponse {
    private Integer cylinder;
    private Integer cylinderCapacity;
    private Integer manuId;
    private String manuText;
    private String motorCode;
    private Integer motorId;
    private Integer powerHP;
    private Integer powerKW;
}
