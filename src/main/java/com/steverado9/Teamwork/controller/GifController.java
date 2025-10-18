package com.steverado9.Teamwork.controller;

import com.steverado9.Teamwork.entity.Article;
import com.steverado9.Teamwork.entity.Gif;
import com.steverado9.Teamwork.entity.GifComment;
import com.steverado9.Teamwork.entity.User;
import com.steverado9.Teamwork.service.GifCommentService;
import com.steverado9.Teamwork.service.GifService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class GifController {

    private GifService gifService;

    private GifCommentService gifCommentService;

    public GifController(GifService gifService, GifCommentService gifCommentService) {
        super();
        this.gifService = gifService;
        this.gifCommentService = gifCommentService;
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

    @DeleteMapping("/api/v1/gifs/delete/{id}")
    public String deleteGif(@PathVariable Long id) {
        gifService.deleteGifById(id);
        return "redirect:/api/v1/feeds";
    }

    @GetMapping("/api/v1/gifs/{id}/comment")
    public String createCommentForm(@PathVariable Long id, Model model){
        GifComment gifComment = new GifComment();
        model.addAttribute("gifComment", gifComment);
        model.addAttribute("gifId", id);
        return "create_gif_comment";
    }

    @PostMapping("/api/v1/gifs/{id}/comment")
    public String saveGifComment(@PathVariable Long id, @ModelAttribute("gifComment") GifComment gifComment, HttpSession session) {
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        gifComment.setUser(loggedInUser);

        Gif existingGif = gifService.getGifById(id);
        gifComment.setGif(existingGif);

        gifCommentService.saveGifComment(gifComment);
        return "redirect:/api/v1/feeds";
    }

    @GetMapping("/api/v1/gifs/{id}")
    public String getOneGifForm(@PathVariable Long id, Model model) {
        List<GifComment> comments = gifCommentService.getGifCommentWithId(id);

        if (comments == null|| comments.isEmpty()) {
            return "redirect:/api/v1/feeds";
        }
        
        model.addAttribute("gif", gifService.getGifById(id));
        model.addAttribute("gifComments", comments);
        return "single_gif";
    }
}
