package com.steverado9.Teamwork.service.Impl;

import com.steverado9.Teamwork.entity.GifComment;
import com.steverado9.Teamwork.repository.GifCommentRepository;
import com.steverado9.Teamwork.service.GifCommentService;
import com.steverado9.Teamwork.service.GifService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GifCommentServiceImpl implements GifCommentService {
    private GifCommentRepository gifCommentRepository;

    public GifCommentServiceImpl(GifCommentRepository gifCommentRepository) {
        super();
        this.gifCommentRepository = gifCommentRepository;
    }

    @Override
    public GifComment saveGifComment(GifComment gifComment) {
        return gifCommentRepository.save(gifComment);
    }

    @Override
    public List<GifComment> getGifCommentWithId(Long id) {
        return gifCommentRepository.findByGif_Id(id);
    }


}
