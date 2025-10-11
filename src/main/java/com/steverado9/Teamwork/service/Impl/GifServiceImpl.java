package com.steverado9.Teamwork.service.Impl;

import com.steverado9.Teamwork.entity.Article;
import com.steverado9.Teamwork.entity.Gif;
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

    @Autowired
    private CloudinaryService cloudinaryService;

    public GifServiceImpl(GifRepository gifRepository) {
        super();
        this.gifRepository = gifRepository;
    }

    @Override
    public List<Gif> getAllGif() {
        return gifRepository.findAll();
    }

    @Transactional
    @Override
    public Gif saveGif(Gif gif, final MultipartFile file) throws ChangeSetPersister.NotFoundException {
        FileUploadUtil.assertAllowed(file, FileUploadUtil.IMAGE_PATTERN);
        final String fileName = FileUploadUtil.getFileName(file.getOriginalFilename());
        final CloudinaryResponse response = this.cloudinaryService.uploadFile(file, fileName);
        gif.setImageUrl(response.url);
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
