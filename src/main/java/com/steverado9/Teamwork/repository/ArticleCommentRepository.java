package com.steverado9.Teamwork.repository;

import com.steverado9.Teamwork.entity.ArticleComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleCommentRepository extends JpaRepository<ArticleComment, Long> {
    //custom method
    List<ArticleComment> findByArticle_Id(Long articleId);
}
