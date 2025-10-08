package com.steverado9.Teamwork.service.Impl;

import com.steverado9.Teamwork.entity.Article;
import com.steverado9.Teamwork.entity.Gif;
import com.steverado9.Teamwork.repository.GifRepository;
import com.steverado9.Teamwork.service.GifService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GifServiceImpl implements GifService {

    private GifRepository gifRepository;

    public GifServiceImpl(GifRepository gifRepository) {
        super();
        this.gifRepository = gifRepository;
    }

    @Override
    public List<Gif> getAllGif() {
        return gifRepository.findAll();
    }

    @Override
    public Gif saveGif(Gif gif) {
        return gifRepository.save(gif);
    }

    @Override
    public Gif getGifById(Long id) {
        return gifRepository.findById(id).get();
    }

    @Override
    public Gif updateGif(Gif gif) {
        return gifRepository.save(gif);
    }

    @Override
    public void deleteGifById(Long id) {
        gifRepository.deleteById(id);
    }
}
