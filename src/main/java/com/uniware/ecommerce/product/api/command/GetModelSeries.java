package com.uniware.ecommerce.product.api.command;

import lombok.Data;

@Data
public class GetModelSeries extends AbstractCommand {
    private String country;
    private String linkingTargetType;
    private Integer manuId;

    public String getName() {
        return "getModelSeries";
    }
}
