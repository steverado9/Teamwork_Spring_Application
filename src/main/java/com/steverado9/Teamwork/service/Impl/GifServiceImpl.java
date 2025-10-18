package com.steverado9.Teamwork.service.Impl;

import com.steverado9.Teamwork.entity.Article;
import com.steverado9.Teamwork.entity.Gif;
import com.steverado9.Teamwork.entity.User;
import com.steverado9.Teamwork.repository.GifCommentRepository;
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
    private GifCommentRepository gifCommentRepository;

    @Autowired
    public GifServiceImpl(GifRepository gifRepository, CloudinaryService cloudinaryService, GifCommentRepository gifCommentRepository) {
        super();
        this.gifRepository = gifRepository;
        this.cloudinaryService = cloudinaryService;
        this.gifCommentRepository = gifCommentRepository;
    }

    @Override
    public List<Gif> getAllGifs() {
        return gifRepository.findAllByOrderByCreatedAtDesc();
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

    @Transactional
    @Override
    public void deleteGifById(Long id) {
        gifCommentRepository.deleteByGifId(id);
        gifRepository.deleteById(id);
    }
}
