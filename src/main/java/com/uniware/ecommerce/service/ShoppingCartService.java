package com.uniware.ecommerce.service;

import com.uniware.ecommerce.model.dto.Product;
import com.uniware.ecommerce.model.dto.ShoppingCart;

public interface ShoppingCartService {

    ShoppingCart create();

    ShoppingCart addProduct(ShoppingCart cart, Product product);

    ShoppingCart updateProduct(ShoppingCart cart, Product product);

    ShoppingCart read(Long id);

    ShoppingCart removeProduct(ShoppingCart build, Product product);
}
