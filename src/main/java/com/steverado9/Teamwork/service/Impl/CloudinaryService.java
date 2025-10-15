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
        System.out.println("upload one");
        if (file == null || file.isEmpty()) {
            throw new IllegalArgumentException("File is empty or null");
        }
        try {
            System.out.println("enter try");
            final Map result = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
            System.out.println("upload two == > " + result);
            final String url = (String) result.get("secure_url");
            System.out.println("upload three");
            return url;
        } catch (Exception e) {
            throw new RuntimeException("Failed to upload file" + e.getMessage(), e);
        }
    }
}
