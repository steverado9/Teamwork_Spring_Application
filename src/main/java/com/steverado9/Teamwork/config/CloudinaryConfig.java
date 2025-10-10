package com.steverado9.Teamwork.config;

import com.cloudinary.Cloudinary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CloudinaryConfig {
    @Bean
    public Cloudinary cloudinary() {
        final Map<String, String> config = new HashMap<>();
        config.put("cloud_name", "dqyctehvd");
        config.put("api_key", "679223967836894");
        config.put("api_secret", "8Rf1XhTDcUQdVDPwmSwJ8f_ZoUU");
        return new Cloudinary(config);
    }
}
