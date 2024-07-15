package com.ohgiraffers.post_st.model.dto;


// JunBlogDTO 클래스는 블로그 게시물의 데이터 전송 객체를 나타냄
public class JunBlogDTO {

    // 데이터 전송 객체로, 클라이언트와 서버 간의 데이터를 전달하는 데 사용됩니다.
    // 엔티티와 달리 비즈니스 로직을 포함하지 않음

    private Long id;

    private String blogTitle;

    private String blogContent;

    public JunBlogDTO() {
    }

    public JunBlogDTO(Long id, String blogTitle, String blogContent) {
        this.id = id;
        this.blogTitle = blogTitle;
        this.blogContent = blogContent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
                "id=" + id +
                ", blogTitle='" + blogTitle + '\'' +
                ", blogContent='" + blogContent + '\'' +
                '}';
    }
}
