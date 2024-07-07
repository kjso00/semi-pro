package com.ohgiraffers.post_st.model.dto;


// JunBlogDTO 클래스는 블로그 게시물의 데이터 전송 객체를 나타냄
public class JunBlogDTO {

    private String blogTitle;

    private String blogContent;

    public JunBlogDTO() {
    }

    public JunBlogDTO(String blogTitle, String blogContent) {
        this.blogTitle = blogTitle;
        this.blogContent = blogContent;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }

    @Override
    public String toString() {
        return "JunBlogDTO{" +
                "blogTitle='" + blogTitle + '\'' +
                ", blogContent='" + blogContent + '\'' +
                '}';
    }
}
