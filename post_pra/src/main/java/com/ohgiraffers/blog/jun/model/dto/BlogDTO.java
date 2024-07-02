package com.ohgiraffers.blog.jun.model.dto;

//BlogDTO 클래스는 블로그 게시물의 데이터를 담는 데이터 전송 객체
public class BlogDTO {

    //블로그 제목을 저장하는 변수
    private String blogTitle;

    // 블로그 내용을 저장하는 변수
    private String blogContent;

    // 기본 생성자
    public BlogDTO() {
    }
    // 매개변수가 있는 생성자
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

    // 객체의 문자열 표현을 반환하는 toString 메서드
    @Override
    public String toString() {
        return "BlogDTO{" +
                "blogTitle='" + blogTitle + '\'' +
                ", blogContent='" + blogContent + '\'' +
                '}';
    }
}

// 블로그 게시물의 데이터를 저장하는 'BlogDTO' 클래스.
// 'BlogDTO'는 데이터 전송 객체로, 블로그 제목과 내용을 저장하기 위한 변수를 갖고있음
// 기본 생성자와 매개변수가 있는 생성자를 제공하여 객체를 생성할 수 있음
//각 변수에 접근하고 수정할 수 있는 getter와 setter 메서드가 포함되어 있습니다. toString 메서드는 객체의 상태를 문자열로 표현하는 데 사용됩니다.
