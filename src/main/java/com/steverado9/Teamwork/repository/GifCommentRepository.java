package com.steverado9.Teamwork.repository;

import com.steverado9.Teamwork.entity.ArticleComment;
import com.steverado9.Teamwork.entity.GifComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GifCommentRepository extends JpaRepository<GifComment, Long> {
    List<GifComment> findByGif_Id(Long gifId);
    void deleteByGifId(Long gifId);
}
