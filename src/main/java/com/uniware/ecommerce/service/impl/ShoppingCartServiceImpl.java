package com.uniware.ecommerce.service.impl;

import com.uniware.ecommerce.model.entity.ProductEntity;
import com.uniware.ecommerce.model.entity.ShoppingCartEntity;
import com.uniware.ecommerce.model.dto.Product;
import com.uniware.ecommerce.model.dto.ShoppingCart;
import com.uniware.ecommerce.repository.ProductEntityRepository;
import com.uniware.ecommerce.repository.ShoppingCartEntityRepository;
import com.uniware.ecommerce.model.entity.ArticleEntity;
import com.uniware.ecommerce.model.entity.Stock;
import com.uniware.ecommerce.repository.ArticleRepository;
import com.uniware.ecommerce.repository.StockRepository;
import com.uniware.ecommerce.service.ShoppingCartService;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private ShoppingCartEntityRepository shoppingCartRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private ProductEntityRepository productRepository;

    @Autowired
    private StockRepository stockRepository;

    @Override
    public ShoppingCart create() {
        final ShoppingCartEntity shoppingCart = shoppingCartRepository.save(new ShoppingCartEntity());

        return mapper.map(shoppingCart, ShoppingCart.class);
    }

    @Transactional
    @Override
    public ShoppingCart addProduct(ShoppingCart cart, Product product) {
        final ShoppingCartEntity shoppingCartEntity = shoppingCartRepository.getById(cart.getId());
        List<ProductEntity> products = shoppingCartEntity.getProducts();

        Optional<ProductEntity> op = products.stream()
                .filter(pe -> StringUtils.equals(pe.getArticle().getSku(), product.getSku())).findFirst();

        if (op.isPresent()) {
            int quantity = op.get().getQuantity().intValue();
            quantity += product.getQuantity().intValue();

            if (quantity == 0) {
                shoppingCartEntity.getProducts().remove(op.get());
                shoppingCartRepository.save(shoppingCartEntity);
                productRepository.delete(op.get());
            } else {
                op.get().setQuantity(quantity);
                ProductEntity productEntity = op.get();
                productEntity.setQuantity(quantity);
                productRepository.save(productEntity);
            }

        } else {
            Optional<ArticleEntity> article = articleRepository.findBySku(product.getSku());

            if (article.isPresent()) {
                Optional<Stock> stock = stockRepository.findByArticle(article.get());
                ProductEntity productEntity = mapper.map(article.get(), ProductEntity.class);
                productEntity.setArticle(article.get());
                productEntity.setPrice(stock.get().getSalePrice());
                productEntity.setShoppingCart(shoppingCartEntity);
                productEntity.setQuantity(product.getQuantity());
                productEntity.setId(null);

                productRepository.save(productEntity);
                shoppingCartEntity.getProducts().add(productEntity);

                shoppingCartRepository.save(shoppingCartEntity);
            }
        }

        ShoppingCart shoppingCart = calculateTotals(shoppingCartEntity);
        return shoppingCart;
    }

    @Override
    public ShoppingCart updateProduct(ShoppingCart cart, Product product) {
        final ShoppingCartEntity shoppingCartEntity = shoppingCartRepository.getById(cart.getId());
        List<ProductEntity> products = shoppingCartEntity.getProducts();

        Optional<ProductEntity> op = products.stream()
                .filter(pe -> StringUtils.equals(pe.getArticle().getSku(), product.getSku())).findFirst();

        if (op.isPresent()) {
            op.get().setQuantity(product.getQuantity());

            shoppingCartRepository.save(shoppingCartEntity);
        }

        ShoppingCart shoppingCart = calculateTotals(shoppingCartEntity);
        return shoppingCart;
    }

    @Override
    public ShoppingCart read(Long id) {
        final ShoppingCartEntity shoppingCartEntity = shoppingCartRepository.getById(id);

        ShoppingCart shoppingCart = calculateTotals(shoppingCartEntity);
        return shoppingCart;
    }

    @Override
    public ShoppingCart removeProduct(ShoppingCart cart, Product product) {
        final ShoppingCartEntity shoppingCartEntity = shoppingCartRepository.getById(cart.getId());
        List<ProductEntity> products = shoppingCartEntity.getProducts();

        Optional<ProductEntity> op = products.stream()
                .filter(pe -> StringUtils.equals(pe.getArticle().getSku(), product.getSku())).findFirst();

        if(op.isPresent()) {
            shoppingCartEntity.getProducts().remove(op.get());
            shoppingCartRepository.save(shoppingCartEntity);
            productRepository.delete(op.get());
        }

        ShoppingCart shoppingCart = calculateTotals(shoppingCartEntity);
        return shoppingCart;
    }

    private ShoppingCart calculateTotals(ShoppingCartEntity shoppingCartEntity) {
        ShoppingCart shoppingCart = mapper.map(shoppingCartEntity, ShoppingCart.class);
        shoppingCart.getProducts().stream().forEachOrdered(p -> {
            p.setTotal(p.getPrice().multiply(new BigDecimal(p.getQuantity())));
        });

        shoppingCart.setTotal(shoppingCart.getProducts().stream().map(Product::getTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add));
        return shoppingCart;
    }
}
