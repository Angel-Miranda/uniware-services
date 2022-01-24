package com.uniware.ecommerce.product.service;

import com.uniware.ecommerce.product.model.Manufacturer;
import com.uniware.ecommerce.product.model.Model;

import java.util.List;

public interface ModelService {
    List<Model> getModelsByManufacturer(Manufacturer manufacturer);
}
