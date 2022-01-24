package com.uniware.ecommerce.product.service;

import com.uniware.ecommerce.product.model.Manufacturer;
import com.uniware.ecommerce.product.model.Model;
import com.uniware.ecommerce.product.model.Vehicle;

import java.util.List;

public interface VehicleService {
    List<Vehicle> getVehicles(Manufacturer manufacturer, Model model);
}
