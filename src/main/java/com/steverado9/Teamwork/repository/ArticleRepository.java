package com.steverado9.Teamwork.repository;

import com.steverado9.Teamwork.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
