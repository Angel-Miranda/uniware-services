package com.uniware.ecommerce.product.service.impl;

import com.uniware.ecommerce.product.api.command.GetVehicleByIds;
import com.uniware.ecommerce.product.api.command.GetVehicleIdsByCriteria;
import com.uniware.ecommerce.product.api.command.TecArray;
import com.uniware.ecommerce.product.api.engine.Engine;
import com.uniware.ecommerce.product.api.response.Response;
import com.uniware.ecommerce.product.api.response.VehicleIdResponse;
import com.uniware.ecommerce.product.api.response.VehicleResponse;
import com.uniware.ecommerce.product.model.Manufacturer;
import com.uniware.ecommerce.product.model.Model;
import com.uniware.ecommerce.product.model.Vehicle;
import com.uniware.ecommerce.product.service.VehicleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private Engine engine;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<Vehicle> getVehicles(Manufacturer manufacturer, Model model) {
        GetVehicleIdsByCriteria command = new GetVehicleIdsByCriteria();
        command.setCarType(engine.getLinkingTargetType());
        command.setLang(engine.getLang());
        command.setCountriesCarSelection("MX");
        command.setManuId(manufacturer.getId());
        command.setModId(model.getId());
        command.setProvider(engine.getProvider());

        Response<VehicleIdResponse> idResponse = engine.execute(command);

        List<Long> ids = idResponse.getData().getArray().stream().map(VehicleIdResponse::getCarId).collect(Collectors.toList());

        GetVehicleByIds command2 = new GetVehicleByIds();
        command2.setLang(engine.getLang());
        command2.setProvider(engine.getProvider());
        command2.setArticleCountry("MX");
        command2.setCountry(engine.getCountry());
        command2.setCountriesCarSelection("MX");
        command2.setCarIds(new TecArray<>(ids));

        Response<VehicleResponse> response = engine.execute(command2);

        return response.getData().getArray().stream().map(v -> mapper.map(v, Vehicle.class)).collect(Collectors.toList());
    }

}
