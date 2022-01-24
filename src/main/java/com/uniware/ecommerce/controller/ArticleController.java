package com.uniware.ecommerce.controller;

import com.uniware.ecommerce.product.model.Article;
import com.uniware.ecommerce.product.model.Page;
import com.uniware.ecommerce.product.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.uniware.ecommerce.util.Constant.WebPaths.ARTICLES;

@RestController
@RequestMapping(ARTICLES)
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping
    public Page<Article> getArticles(@RequestParam(name = "p", required = false) Integer page,
                                     @RequestParam(name = "s", required = false) Integer pageSize) {

        return articleService.getArticles(page, pageSize);
    }
}
