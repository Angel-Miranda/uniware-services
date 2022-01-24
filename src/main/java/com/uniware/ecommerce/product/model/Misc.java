package com.uniware.ecommerce.product.model;

import lombok.Data;

@Data
public class Misc {
    private ArticleStatus status;
    private Integer quantityPerPackage;
    private Integer quantityPerPartPerPackage;
    private Boolean isSelfServicePacking;
    private Boolean hasMandatoryMaterialCertification;
    private Boolean isRemanufacturedPart;
    private Boolean isAccessory;
}
