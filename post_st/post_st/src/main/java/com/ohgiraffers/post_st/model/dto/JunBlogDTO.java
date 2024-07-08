package com.ohgiraffers.post_st.model.dto;


// JunBlogDTO 클래스는 블로그 게시물의 데이터 전송 객체를 나타냄
public class JunBlogDTO {

    private Long blogid;

    private String blogTitle;

    private String blogContent;



    public JunBlogDTO() {
    }

    public JunBlogDTO(Long blogid, String blogTitle, String blogContent) {
        this.blogid = blogid;
        this.blogTitle = blogTitle;
        this.blogContent = blogContent;
    }

    public long getId() {
        return blogid;
    }

    public void setId(Long id) {
        this.blogid = blogid;
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
                "blogid=" + blogid +
                ", blogTitle='" + blogTitle + '\'' +
                ", blogContent='" + blogContent + '\'' +
                '}';
    }


}
