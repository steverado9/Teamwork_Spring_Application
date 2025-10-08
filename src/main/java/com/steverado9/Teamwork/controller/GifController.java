package com.steverado9.Teamwork.controller;

import com.steverado9.Teamwork.entity.Article;
import com.steverado9.Teamwork.entity.Gif;
import com.steverado9.Teamwork.entity.User;
import com.steverado9.Teamwork.service.GifService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GifController {

    private GifService gifService;

    public GifController(GifService gifService) {
        super();
        this.gifService = gifService;
    }

    @GetMapping("/api/v1/gifs")
    public String createGifForm(Model model, HttpSession session) {
        User loggedInUser = (User) session.getAttribute("loggedInUser");

        if (loggedInUser == null) {
            return "redirect:/api/v1/auth/sign_in";
        }
        Gif gif = new Gif();
        model.addAttribute("gif", gif);
        return "create_gif";
    }
}
