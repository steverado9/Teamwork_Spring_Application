package com.steverado9.Teamwork.controller;

import com.steverado9.Teamwork.entity.Article;
import com.steverado9.Teamwork.entity.Gif;
import com.steverado9.Teamwork.entity.User;
import com.steverado9.Teamwork.service.GifService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @PostMapping("/api/v1/gifs")
    public String saveGif( @RequestPart("file") MultipartFile file ,
                           @ModelAttribute("gif") Gif gif,
                           HttpSession session,
                           RedirectAttributes redirectAttributes ) {
        try{
            User loggedInUser = (User) session.getAttribute("loggedInUser");
            if (loggedInUser == null) {
                return "redirect:/api/v1/auth/sign_in";
            }

            gif.setUser(loggedInUser);
            gifService.saveGif(gif, file);

            redirectAttributes.addFlashAttribute("successMessage", "GIF uploaded successfully!");
            return "redirect:/api/v1/feeds";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Upload failed: " + e.getMessage());
            return "redirect:/api/v1/gifs";
        }
    }
}
