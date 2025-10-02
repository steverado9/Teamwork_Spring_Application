package com.steverado9.Teamwork.service.Impl;

import com.steverado9.Teamwork.entity.ArticleComment;
import com.steverado9.Teamwork.repository.ArticleCommentRepository;
import com.steverado9.Teamwork.service.ArticleCommentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleCommentServiceImpl implements ArticleCommentService {

    private ArticleCommentRepository articleCommentRepository;

    public ArticleCommentServiceImpl(ArticleCommentRepository articleCommentRepository) {
        super();
        this.articleCommentRepository = articleCommentRepository;
    }

    @Override
    public ArticleComment saveArticleComment(ArticleComment articleComment) {
        return articleCommentRepository.save(articleComment);
    }

    @Override
    public List<ArticleComment> getArticleCommentsWithId(Long id) {
        //This is a list of article comments
        return articleCommentRepository.findByArticle_Id(id);
    }

}
