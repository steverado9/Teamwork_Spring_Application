package com.steverado9.Teamwork.service;

import com.steverado9.Teamwork.entity.ArticleComment;

import java.util.List;

public interface ArticleCommentService {
    List<ArticleComment> getArticleCommentsWithId(Long id);

    ArticleComment saveArticleComment(ArticleComment articleComment);
}
