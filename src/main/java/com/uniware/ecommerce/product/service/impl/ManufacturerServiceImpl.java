package com.uniware.ecommerce.product.service.impl;

import com.uniware.ecommerce.product.api.command.GetManufacturers;
import com.uniware.ecommerce.product.api.engine.Engine;
import com.uniware.ecommerce.product.api.response.ManufacturerResponse;
import com.uniware.ecommerce.product.api.response.Response;
import com.uniware.ecommerce.product.model.Manufacturer;
import com.uniware.ecommerce.product.service.ManufacturerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {
    @Value("${tech-alliance.api.country}")
    private String country;

    @Value("${tech-alliance.api.lang}")
    private String lang;

    @Value("${tech-alliance.api.linkingTargetType}")
    private String linkingTargetType;

    @Value("${tech-alliance.api.provider}")
    private Integer provider;

    @Autowired
    private Engine engine;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<Manufacturer> getManufacturers() {
        GetManufacturers command = new GetManufacturers();
        command.setCountry(country);
        command.setLang(lang);
        command.setLinkingTargetType(linkingTargetType);
        command.setProvider(provider);

        Response<ManufacturerResponse> response = engine.execute(command);

        return response.getData().getArray().stream()
                .map(i -> mapper.map(i, Manufacturer.class))
                .collect(Collectors.toList());
    }
}
