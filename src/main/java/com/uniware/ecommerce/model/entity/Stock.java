package com.uniware.ecommerce.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name = "article_stocks")
public class Stock implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private ArticleEntity article;

    private Integer quantity;

    private BigDecimal purchasePrice;

    private BigDecimal salePrice;

}
