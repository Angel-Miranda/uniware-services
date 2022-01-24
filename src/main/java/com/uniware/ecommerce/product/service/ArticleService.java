package com.uniware.ecommerce.product.service;

import com.uniware.ecommerce.product.model.Article;
import com.uniware.ecommerce.product.model.Page;

public interface ArticleService {

    Page<Article> getArticles(Integer page, Integer pageSize);
}
