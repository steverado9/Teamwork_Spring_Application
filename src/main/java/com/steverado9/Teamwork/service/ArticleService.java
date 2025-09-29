package com.steverado9.Teamwork.service;

import com.steverado9.Teamwork.entity.Article;

import java.util.List;

public interface ArticleService {
    List<Article> getAllArticles();

    Article saveArticle(Article article);

    Article getArticleById(Long id);

    Article updateArticle(Article article);

    void deleteArticleById(Long id);

}
