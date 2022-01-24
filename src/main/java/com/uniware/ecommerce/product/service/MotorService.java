package com.uniware.ecommerce.product.service;

import com.uniware.ecommerce.product.model.Manufacturer;
import com.uniware.ecommerce.product.model.Motor;

import java.util.List;

public interface MotorService {
    List<Motor> getMotorsByManufacturer(Manufacturer manufacturer);
}
