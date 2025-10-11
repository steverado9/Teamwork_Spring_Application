package com.steverado9.Teamwork.service;

import com.steverado9.Teamwork.entity.Gif;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface GifService {
    List<Gif> getAllGif();

    Gif saveGif(Gif gif, final MultipartFile file) throws ChangeSetPersister.NotFoundException;

    Gif getGifById(Long id);

    Gif updateGif(Gif gif);

    void deleteGifById(Long id);
}
