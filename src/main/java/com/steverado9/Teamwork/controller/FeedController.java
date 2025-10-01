package com.steverado9.Teamwork.controller;

import com.steverado9.Teamwork.service.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FeedController {

    private ArticleService articleService;

    public FeedController(ArticleService articleService) {
        super();
        this.articleService = articleService;
    }

    @GetMapping("/api/v1/feeds")
    public String listOfArticles(Model model) {
        model.addAttribute("articles", articleService.getAllArticles());
        return "feeds";
    }

}
