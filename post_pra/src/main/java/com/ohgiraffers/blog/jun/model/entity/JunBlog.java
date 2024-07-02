package com.ohgiraffers.blog.jun.model.entity;


import jakarta.persistence.*;

import java.util.Date;

// JunBlog 클래스는 블로그 게시물 엔티티를 나타냅니다.
@Entity
@Table(name = "jun_blog") // 데이터베이스의 jun_blog 테이블에 매핑된다.
public class JunBlog {

    //기본 키로 사용될 필드
    @Id
    @Column(name = "blog_no") // 컬럼 이름 매핑
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본 키 생성을 데이터베이스에 위임 (AUTO_INCREMENT)
    private int blogNo;

    @Column(name = "blog_title", unique = true, nullable = false) // 블로그 제목 컬럼, 유니크 제약 조건 및 널 허용 안 함
    private String blogTitle;

    @Column(name = "blog_content", nullable = false, length = 5000) // 블로그 내용 컬럼, 널 허용 안 하며 최대 길이 5000
    private String blogContent;

    @Column(name = "creation_date") // 생성일 컬럼
    @Temporal(TemporalType.TIMESTAMP) // 날짜와 시간을 지정
    private Date createDate;

    // 기본 생성자

    public JunBlog() {
    }

    // 매개변수가 있는 생성자

    public JunBlog(int blogNo, String blogTitle, String blogContent, Date createDate) {
        this.blogNo = blogNo;
        this.blogTitle = blogTitle;
        this.blogContent = blogContent;
        this.createDate = createDate;
    }

    // blogNo의 getter 메서드
    public int getBlogNo() {
        return blogNo;
    }

    // blogNo의 setter 메서드
    public void setBlogNo(int blogNo) {
        this.blogNo = blogNo;
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

    // createDate의 getter 메서드
    public Date getCreateDate() {
        return createDate;
    }

    // createDate의 setter 메서드
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    // 객체의 문자열 표현을 반환하는 toString 메서드

    @Override
    public String toString() {
        return "JunBlog{" +
                "blogNo=" + blogNo +
                ", blogTitle='" + blogTitle + '\'' +
                ", blogContent='" + blogContent + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}

// 이 클래스는 JPA를 사용하여 데이터베이스의 jaesuk_blog 테이블과 매핑
// 각 필드는 테이블의 컬럼에 매핑되며, blogNo 필드는 기본 키로 설정