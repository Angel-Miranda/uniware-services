package com.uniware.ecommerce.product.service.impl;

import com.uniware.ecommerce.product.api.command.GetAmBrands;
import com.uniware.ecommerce.product.api.engine.Engine;
import com.uniware.ecommerce.product.api.response.BrandResponse;
import com.uniware.ecommerce.product.api.response.Response;
import com.uniware.ecommerce.product.model.Brand;
import com.uniware.ecommerce.product.service.BrandService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private Engine engine;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<Brand> getBrands() {
        GetAmBrands command = new GetAmBrands();
        command.setProvider(engine.getProvider());
        command.setLang(engine.getLang());
        command.setArticleCountry("MX");

        Response<BrandResponse> response = engine.execute(command);
        return response.getData().getArray().stream().map(b -> mapper.map(b, Brand.class)).collect(Collectors.toList());
    }
}
