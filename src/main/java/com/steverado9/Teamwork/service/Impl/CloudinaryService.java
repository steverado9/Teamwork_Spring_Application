package com.steverado9.Teamwork.service.Impl;

import com.cloudinary.Cloudinary;
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
    public CloudinaryResponse uploadFile(MultipartFile file, String fileName) {
        try {
            final Map result = cloudinary.uploader().upload(file.getBytes(), Map.of("public_id", "/gifs" + fileName));
            final String url = (String) result.get("secure_url");
            final String publicId = (String) result.get("public_id");
            CloudinaryResponse response = new CloudinaryResponse(publicId, url);
            return response;
        } catch (Exception e) {
            throw new UnsupportedOperationException("Failed to upload file");
        }
    }
}
