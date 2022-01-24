package com.uniware.ecommerce.product.api.command;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class TecArray<T> {
    private List<T> array;
}
