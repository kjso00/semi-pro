package com.ohgiraffers.DTO;

public class PostDTO {

    private String region;
    private String thumbnailUrl;
    private String author;
    private String previewText;

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPreviewText() {
        return previewText;
    }

    public void setPreviewText(String previewText) {
        this.previewText = previewText;
    }

    public PostDTO(String region, String thumbnailUrl, String author, String previewText) {
        this.region = region;
        this.thumbnailUrl = thumbnailUrl;
        this.author = author;
        this.previewText = previewText;
    }
}
