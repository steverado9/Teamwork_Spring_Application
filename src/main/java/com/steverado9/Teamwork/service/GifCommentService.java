package com.steverado9.Teamwork.service;

import com.steverado9.Teamwork.entity.GifComment;

import java.util.List;

public interface GifCommentService {
    List<GifComment> getGifCommentWithId(Long id);

    GifComment saveGifComment(GifComment gifComment);

}
