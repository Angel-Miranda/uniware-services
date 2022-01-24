package com.uniware.ecommerce.product.service.impl;

import com.uniware.ecommerce.product.api.command.GetMotorsByCarTypeManuId;
import com.uniware.ecommerce.product.api.engine.Engine;
import com.uniware.ecommerce.product.api.response.MotorResponse;
import com.uniware.ecommerce.product.api.response.Response;
import com.uniware.ecommerce.product.model.Manufacturer;
import com.uniware.ecommerce.product.model.Motor;
import com.uniware.ecommerce.product.service.MotorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MotorServiceImpl implements MotorService {
    @Autowired
    private Engine engine;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<Motor> getMotorsByManufacturer(Manufacturer manufacturer) {
        GetMotorsByCarTypeManuId command = new GetMotorsByCarTypeManuId();
        command.setProvider(engine.getProvider());
        command.setLang(engine.getLang());
        command.setCarType(engine.getLinkingTargetType());
        command.setCountriesCarSelection("MX");
        command.setManuId(manufacturer.getId().intValue());
        Response<MotorResponse> response = engine.execute(command);

        return response.getData().getArray().stream().map(m -> mapper.map(m, Motor.class)).collect(Collectors.toList());
    }
}
