package com.steverado9.Teamwork.controller;

import com.steverado9.Teamwork.entity.Article;
import com.steverado9.Teamwork.entity.ArticleComment;
import com.steverado9.Teamwork.entity.User;
import com.steverado9.Teamwork.service.ArticleCommentService;
import com.steverado9.Teamwork.service.ArticleService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ArticleController {

    private ArticleService articleService;

    private ArticleCommentService articleCommentService;

    public ArticleController(ArticleService articleService, ArticleCommentService articleCommentService) {
        super();
        this.articleService = articleService;
        this.articleCommentService = articleCommentService;
    }

    @GetMapping("/api/v1/articles")
    public String createArticleForm(Model model, HttpSession session) {
        User loggedInUser = (User) session.getAttribute("loggedInUser");

        if (loggedInUser == null) {
            return "redirect:/api/v1/auth/sign_in";
        }
        Article article = new Article();
        model.addAttribute("article", article);
        return "create_article";
    }

    @PostMapping("/api/v1/articles")
    public String saveArticle(@ModelAttribute("article") Article article, HttpSession session, RedirectAttributes redirectAttributes) {
        //get logged-in user from session
        User loggedInUser = (User) session.getAttribute("loggedInUser");

        if(loggedInUser == null) {
            return "redirect:/api/v1/auth/sign_in";
        }

        //Attach user to article
        article.setUser(loggedInUser);
        articleService.saveArticle(article);

        //successfully added article
        redirectAttributes.addFlashAttribute("successMessage", "article created sucessfully!");

        return "redirect:/api/v1/feeds";
    }

    @GetMapping("/api/v1/articles/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model) {
        model.addAttribute("article", articleService.getArticleById(id));
        return "edit_article";
    }

    @PutMapping("/api/v1/articles/{id}")
    public String updateArticle(@PathVariable Long id, @ModelAttribute("article") Article article, Model model) {
        //get article from database by id
        Article existingArticle = articleService.getArticleById(id);
        existingArticle.setId(id);
        existingArticle.setTitle(article.getTitle());
        existingArticle.setContent(article.getContent());

        //save updated article object
        articleService.updateArticle(existingArticle);
        return "redirect:/api/v1/feeds";
    }

    @DeleteMapping("/api/v1/articles/delete/{id}")
    public String deleteArticle(@PathVariable Long id) {
        articleService.deleteArticleById(id);
        return "redirect:/api/v1/feeds";
    }

    @GetMapping("/api/v1/articles/{id}/comment")
    public String createCommentForm(Model model) {
        ArticleComment articleComment = new ArticleComment();
        model.addAttribute("comment", articleComment);
        return "create_article_comment";
    }

    @PostMapping("/api/v1/articles/{id}/comment")
    public String saveArticleComment(@PathVariable Long id, @ModelAttribute("comment") ArticleComment articleComment,HttpSession session) {
        //get user from the session
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        articleComment.setUser(loggedInUser);

        //get article by id
        Article existingArticle = articleService.getArticleById(id);
        articleComment.setArticle(existingArticle);

        articleCommentService.saveArticleComment(articleComment);
        return "redirect:/api/v1/feeds";
    }

    @GetMapping("/api/v1/articles/{id}")
    public String getOneArticleForm (@PathVariable Long id, Model model) {
        model.addAttribute("article",  articleService.getArticleById(id));
        model.addAttribute("articleComments", articleCommentService.getArticleCommentsWithId(id));
        return "single_article";
    }
}
