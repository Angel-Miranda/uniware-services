package com.uniware.ecommerce.controller;

import com.uniware.ecommerce.product.model.Manufacturer;
import com.uniware.ecommerce.product.model.Model;
import com.uniware.ecommerce.product.model.Motor;
import com.uniware.ecommerce.product.model.Vehicle;
import com.uniware.ecommerce.product.service.ManufacturerService;
import com.uniware.ecommerce.product.service.ModelService;
import com.uniware.ecommerce.product.service.MotorService;
import com.uniware.ecommerce.product.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.uniware.ecommerce.util.Constant.WebPaths.*;

@RestController
@RequestMapping(MANUFACTURERS)
public class ManufacturerController {
    @Autowired
    private ManufacturerService manufacturerService;

    @Autowired
    private ModelService modelService;

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private MotorService motorService;

    @GetMapping
    public List<Manufacturer> getManufacturers() {
        return manufacturerService.getManufacturers();
    }

    @GetMapping(MODELS_BY_MANUFACTURER)
    public List<Model> getModelsByManufacturer(@PathVariable Long manufacturerId) {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setId(manufacturerId);

        return modelService.getModelsByManufacturer(manufacturer);
    }

    @GetMapping(VEHICLES_BY_MODEL)
    public List<Vehicle> getVehicles(@PathVariable Long manufacturerId, @PathVariable Long modelId) {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setId(manufacturerId);

        Model model = new Model();
        model.setId(modelId);

        return vehicleService.getVehicles(manufacturer, model);
    }

    @GetMapping(MOTORS_BY_MANUFACTURER)
    public List<Motor> getMotorsByManufacturer(@PathVariable Long manufacturerId) {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setId(manufacturerId);

        return motorService.getMotorsByManufacturer(manufacturer);
    }

}
