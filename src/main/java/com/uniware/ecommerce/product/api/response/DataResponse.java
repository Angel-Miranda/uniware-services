package com.uniware.ecommerce.product.api.response;

import lombok.Data;

import java.util.List;

@Data
public class DataResponse<T> {
    private List<T> array;
}
