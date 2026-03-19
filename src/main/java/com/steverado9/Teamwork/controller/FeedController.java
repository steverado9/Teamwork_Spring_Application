package com.steverado9.Teamwork.controller;

import com.steverado9.Teamwork.entity.User;
import com.steverado9.Teamwork.service.ArticleService;
import com.steverado9.Teamwork.service.GifService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FeedController {

    private ArticleService articleService;
    private GifService gifService;

    public FeedController(ArticleService articleService, GifService gifService) {
        super();
        this.articleService = articleService;
        this.gifService = gifService;
    }

    @GetMapping("/feeds")
    public String listOfArticlesAndGifs(Model model, HttpSession session) {
        User loggedInUser = (User) session.getAttribute("loggedInUser");

        if(loggedInUser == null) {
            System.out.println("user does not exist");
            return "redirect:sign_in";
        }

        model.addAttribute("articles", articleService.getAllArticles());
        model.addAttribute("gifs", gifService.getAllGifs());
        model.addAttribute("admin",  loggedInUser.getJobRole().equalsIgnoreCase("admin"));
        model.addAttribute("user", loggedInUser);

        return "feeds";
    }
}
