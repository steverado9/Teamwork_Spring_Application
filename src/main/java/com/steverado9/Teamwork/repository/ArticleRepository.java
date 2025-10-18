package com.steverado9.Teamwork.repository;

import com.steverado9.Teamwork.entity.Article;
import com.steverado9.Teamwork.entity.ArticleComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findAllByOrderByCreatedAtDesc();
}
