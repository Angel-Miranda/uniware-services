package com.uniware.ecommerce.product.service.impl;

import com.uniware.ecommerce.product.api.command.GetModelSeries;
import com.uniware.ecommerce.product.api.engine.Engine;
import com.uniware.ecommerce.product.api.response.ModelResponse;
import com.uniware.ecommerce.product.api.response.Response;
import com.uniware.ecommerce.product.model.Manufacturer;
import com.uniware.ecommerce.product.model.Model;
import com.uniware.ecommerce.product.service.ModelService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ModelServiceImpl implements ModelService {

    @Value("${tech-alliance.url}")
    private String url;

    @Value("${tech-alliance.api-key}")
    private String apiKey;

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
    public List<Model> getModelsByManufacturer(Manufacturer manufacturer) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("x-api-key", apiKey);
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        headers.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);

        GetModelSeries getModelsCommand = new GetModelSeries();
        getModelsCommand.setCountry(country);
        getModelsCommand.setLang(lang);
        getModelsCommand.setLinkingTargetType(linkingTargetType);
        getModelsCommand.setManuId(manufacturer.getId().intValue());

        HttpEntity<Map> entity = new HttpEntity<>(getModelsCommand.build(), headers);


        Response<ModelResponse> response = engine.execute(getModelsCommand);

        return response.getData().getArray().stream()
                .map(i -> mapper.map(i, Model.class))
                .collect(Collectors.toList());
    }
}
