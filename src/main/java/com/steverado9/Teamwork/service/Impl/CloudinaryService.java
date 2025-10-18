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

    private final Cloudinary cloudinary;

    public CloudinaryService(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    public String uploadFile(MultipartFile file) {
        if (file == null || file.isEmpty()) {
            throw new IllegalArgumentException("File is empty or null");
        }
        try {
            final Map result = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());

            final String url = (String) result.get("secure_url");

            return url;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to upload file" + e.getMessage(), e);
        }
    }
}
