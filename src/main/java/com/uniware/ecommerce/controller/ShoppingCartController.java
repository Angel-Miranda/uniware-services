package com.uniware.ecommerce.controller;

import com.uniware.ecommerce.model.dto.Product;
import com.uniware.ecommerce.model.dto.ShoppingCart;
import com.uniware.ecommerce.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.uniware.ecommerce.util.Constant.WebPaths.SHOPPING_CARTS;

@RestController
@RequestMapping(SHOPPING_CARTS)
public class ShoppingCartController {
    @Autowired
    private ShoppingCartService shoppingCartService;

    @PostMapping
    public ShoppingCart createShoppingCart() {
        return shoppingCartService.create();
    }

    @GetMapping("/{shoppingCartId}")
    public ShoppingCart addToShoppingCart(@PathVariable Long shoppingCartId) {
        return shoppingCartService.read(shoppingCartId);
    }

    @PostMapping("/{shoppingCartId}/products")
    public ShoppingCart addToShoppingCart(@PathVariable Long shoppingCartId, @RequestBody Product product) {
        return shoppingCartService.addProduct(ShoppingCart.builder().id(shoppingCartId).build(), product);
    }

    @DeleteMapping("/{shoppingCartId}/products")
    public ShoppingCart removeFromShoppingCart(@PathVariable Long shoppingCartId, @RequestBody Product product) {
        return shoppingCartService.removeProduct(ShoppingCart.builder().id(shoppingCartId).build(), product);
    }

    @PatchMapping("{shoppingCartId}/products")
    public ShoppingCart updateShoppingCart(@PathVariable Long shoppingCartId, @RequestBody Product product) {
        return shoppingCartService.updateProduct(ShoppingCart.builder().id(shoppingCartId).build(), product);
    }
}
