package com.steverado9.Teamwork.service.Impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.steverado9.Teamwork.response.CloudinaryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Service
public class CloudinaryService {
    @Autowired
    private Cloudinary cloudinary;

    @Transactional
    public String uploadFile(MultipartFile file) {
        try {
            final Map result = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
            final String url = (String) result.get("secure_url");
            return url;
        } catch (Exception e) {
            throw new UnsupportedOperationException("Failed to upload file");
        }
    }
}
