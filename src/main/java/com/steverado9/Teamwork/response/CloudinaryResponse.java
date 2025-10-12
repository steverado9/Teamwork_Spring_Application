package com.steverado9.Teamwork.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CloudinaryResponse {
    public String publicId;
    public String url;

    public CloudinaryResponse() {}

    public CloudinaryResponse(String publicId, String url) {
        this.publicId = publicId;
        this.url = url;
    }
}
