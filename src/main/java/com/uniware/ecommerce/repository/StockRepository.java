package com.uniware.ecommerce.repository;

import com.uniware.ecommerce.model.entity.ArticleEntity;
import com.uniware.ecommerce.model.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
    Optional<Stock> findByArticle(ArticleEntity article);
}