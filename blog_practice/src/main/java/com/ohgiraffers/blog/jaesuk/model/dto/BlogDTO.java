package com.ohgiraffers.blog.jaesuk.model.dto;

// 블로그 게시물 데이터를 전송하기 위한 DTO 클래스
public class BlogDTO {

    // 블로그 제목을 저장하는 변수
    private String blogTitle;

    // 블로그 내용을 저장하는 변수
    private String blogContent;

    // 기본 생성자
    public BlogDTO() {
    }

    // 매개변수를 가지는 생성자
    public BlogDTO(String blogTitle, String blogContent) {
        this.blogTitle = blogTitle;
        this.blogContent = blogContent;
    }

    // blogTitle의 getter 메서드
    public String getBlogTitle() {
        return blogTitle;
    }

    // blogTitle의 setter 메서드
    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    // blogContent의 getter 메서드
    public String getBlogContent() {
        return blogContent;
    }

    // blogContent의 setter 메서드
    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }

    // 객체를 문자열로 표현하는 메서드 (디버깅용)
    @Override
    public String toString() {
        return "BlogDTO{" +
                "blogTitle='" + blogTitle + '\'' +
                ", blogContent='" + blogContent + '\'' +
                '}';
    }
}
