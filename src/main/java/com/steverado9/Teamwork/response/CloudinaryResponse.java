package com.steverado9.Teamwork.response;


public class CloudinaryResponse {
    public String publicId;
    public String url;

    public CloudinaryResponse() {}

    public CloudinaryResponse(String publicId, String url) {
        this.publicId = publicId;
        this.url = url;
    }
}
