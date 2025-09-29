package com.steverado9.Teamwork.controller;

import com.steverado9.Teamwork.service.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArticleController {

    private ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        super();
        this.articleService = articleService;
    }

    @GetMapping()
}
