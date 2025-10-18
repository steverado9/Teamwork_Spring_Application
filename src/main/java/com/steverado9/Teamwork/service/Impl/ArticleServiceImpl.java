package com.steverado9.Teamwork.service.Impl;

import com.steverado9.Teamwork.entity.Article;
import com.steverado9.Teamwork.repository.ArticleCommentRepository;
import com.steverado9.Teamwork.repository.ArticleRepository;
import com.steverado9.Teamwork.service.ArticleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    private ArticleRepository articleRepository;
    private ArticleCommentRepository articleCommentRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository, ArticleCommentRepository articleCommentRepository) {
        super();
        this.articleRepository = articleRepository;
        this.articleCommentRepository = articleCommentRepository;
    }

    @Override
    public List<Article> getAllArticles() {
        return articleRepository.findAllByOrderByCreatedAtDesc();
    }

    @Override
    public Article saveArticle(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public Article getArticleById(Long id) {
        return articleRepository.findById(id).get();
    }

    @Override
    public Article updateArticle(Article article) {
        return articleRepository.save(article);
    }

    @Transactional
    @Override
    public void deleteArticleById(Long id) {
        articleCommentRepository.deleteByArticleId(id);
        articleRepository.deleteById(id);
    }

}
