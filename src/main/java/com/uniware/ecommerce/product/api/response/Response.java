package com.uniware.ecommerce.product.api.response;

import lombok.Data;

@Data
public class Response<T> {
    private String status;
    private DataResponse<T> data;
}
