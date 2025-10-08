package com.steverado9.Teamwork.service;

import com.steverado9.Teamwork.entity.Gif;

import java.util.List;

public interface GifService {
    List<Gif> getAllGif();

    Gif saveGif(Gif gif);

    Gif getGifById(Long id);

    Gif updateGif(Gif gif);

    void deleteGifById(Long id);
}
