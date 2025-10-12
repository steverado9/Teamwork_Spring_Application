package com.steverado9.Teamwork.service;

import com.steverado9.Teamwork.entity.Gif;
import com.steverado9.Teamwork.entity.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface GifService {
    List<Gif> getAllGif();

    Gif saveGif(Gif gif, MultipartFile file);

    Gif getGifById(Long id);

    Gif updateGif(Gif gif);

    void deleteGifById(Long id);
}
