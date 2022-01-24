package com.uniware.ecommerce.product.api.response;

import lombok.Data;

@Data
public class MiscArticleDataResponse {
    private String additionalDescription;
    private Integer articleStatusId;
    private String articleStatusDescription;
    private Integer articleStatusValidFromDate;
    private Integer quantityPerPackage;
    private Integer quantityPerPartPerPackage;
    private Boolean isSelfServicePacking;
    private Boolean hasMandatoryMaterialCertification;
    private Boolean isRemanufacturedPart;
    private Boolean isAccessory;
    private Integer batchSize1;
    private Integer batchSize2;
}
