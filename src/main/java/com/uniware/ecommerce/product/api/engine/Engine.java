package com.uniware.ecommerce.product.api.engine;

import com.uniware.ecommerce.product.api.command.Command;
import com.uniware.ecommerce.product.api.response.*;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Getter
public class Engine {
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
    private RestTemplate restTemplate;

    public <T> T execute(Command command, Class<T> type) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("x-api-key", apiKey);
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        headers.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);

        HttpEntity entity = new HttpEntity(command.build(), headers);
        return restTemplate.postForObject(url, entity, type);
    }

    public <T> Response<T> execute(Command command) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("x-api-key", apiKey);
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        headers.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);

        HttpEntity entity = new HttpEntity(command.build(), headers);

        switch (command.getName()) {
            case "getManufacturers":
                return (Response<T>) postForObject(url, entity, new ParameterizedTypeReference<Response<ManufacturerResponse>>(){});

            case "getModelSeries":
                return (Response<T>) postForObject(url, entity, new ParameterizedTypeReference<Response<ModelResponse>>(){});

            case "getVehicleByIds3":
                return (Response<T>) postForObject(url, entity, new ParameterizedTypeReference<Response<VehicleResponse>>(){});

            case "getVehicleIdsByCriteria":
                return (Response<T>) postForObject(url, entity, new ParameterizedTypeReference<Response<VehicleIdResponse>>(){});

            case "getAmBrands":
                return (Response<T>) postForObject(url, entity, new ParameterizedTypeReference<Response<BrandResponse>>(){});

            case "getMotorsByCarTypeManuIdTerm2":
                return (Response<T>) postForObject(url, entity, new ParameterizedTypeReference<Response<MotorResponse>>(){});

            default:
                throw new IllegalArgumentException("Error");
        }
    }

    private <T> T postForObject(String url, HttpEntity entity, ParameterizedTypeReference<T> parameterizedTypeReference) {

        return restTemplate.exchange(url, HttpMethod.POST, entity, parameterizedTypeReference).getBody();
    }
}