package com.steverado9.Teamwork.service.Impl;

import com.steverado9.Teamwork.entity.Article;
import com.steverado9.Teamwork.entity.Gif;
import com.steverado9.Teamwork.entity.User;
import com.steverado9.Teamwork.repository.GifRepository;
import com.steverado9.Teamwork.response.CloudinaryResponse;
import com.steverado9.Teamwork.service.GifService;
import com.steverado9.Teamwork.util.FileUploadUtil;
import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class GifServiceImpl implements GifService {

    private GifRepository gifRepository;
    private CloudinaryService cloudinaryService;

    @Autowired
    public GifServiceImpl(GifRepository gifRepository, CloudinaryService cloudinaryService) {
        super();
        this.gifRepository = gifRepository;
        this.cloudinaryService = cloudinaryService;
    }

    @Override
    public List<Gif> getAllGif() {
        return gifRepository.findAll();
    }

    @Transactional
    @Override
    public Gif saveGif(Gif gif, MultipartFile file) {
        FileUploadUtil.assertAllowed(file, FileUploadUtil.IMAGE_PATTERN);


        final String response = cloudinaryService.uploadFile(file);

        gif.setImageUrl(response);

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
