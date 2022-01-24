package com.uniware.ecommerce.controller;

import com.uniware.ecommerce.product.model.Brand;
import com.uniware.ecommerce.product.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.uniware.ecommerce.util.Constant.WebPaths.BRANDS;

@RestController
@RequestMapping(BRANDS)
public class BrandController {
    @Autowired
    private BrandService brandService;

    @GetMapping
    public List<Brand> getBrands() {
        return brandService.getBrands();
    }
}
