package com.uniware.ecommerce.product.api.response;

import lombok.Data;

@Data
public class CriteriaResponse {
    private Integer criteriaId;
    private String criteriaDescription;
    private String criteriaAbbrDescription;
    private String criteriaUnitDescription;
    private String criteriaType;
    private Integer successorCriteriaId;
    private String rawValue;
    private String formattedValue;
    private Boolean immediateDisplay;
    private Boolean isMandatory;
    private Boolean isInterval;
    private Boolean matchesSearchQuery;
}
