package com.uniware.ecommerce.product.service.impl;

import com.uniware.ecommerce.product.api.command.GetArticles;
import com.uniware.ecommerce.product.api.engine.Engine;
import com.uniware.ecommerce.product.api.response.ArticlePagedResponse;
import com.uniware.ecommerce.product.model.Article;
import com.uniware.ecommerce.product.model.Page;
import com.uniware.ecommerce.product.service.ArticleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private Engine engine;

    @Autowired
    private ModelMapper mapper;

    @Override
    public Page<Article> getArticles(Integer page, Integer pageSize) {
        GetArticles command = new GetArticles();
        command.setPage(page);
        command.setPerPage(pageSize);
        command.setIncludeAll(true);
        command.setArticleCountry("MX");
        command.setProvider(engine.getProvider());
        command.setSearchType(0);
        command.setLang(engine.getLang());

        ArticlePagedResponse response = engine.execute(command, ArticlePagedResponse.class);

        Page<Article> pageResponse = new Page<>();
        pageResponse.setTotal(response.getTotalMatchingArticles());
        pageResponse.setTotalPages(response.getMaxAllowedPage());
        pageResponse.setItems(response.getArticles().stream().map(a -> mapper.map(a, Article.class))
                .collect(Collectors.toList()));

        return pageResponse;
    }
}
