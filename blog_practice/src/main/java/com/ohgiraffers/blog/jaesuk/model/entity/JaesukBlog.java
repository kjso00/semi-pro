package com.ohgiraffers.blog.jaesuk.model.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity // 이 클래스가 JPA 엔티티임을 나타냅니다.
@Table(name = "jaesuk_blog") // 데이터베이스 테이블과 매핑되는 클래스임을 나타내며, 테이블 이름을 "jaesuk_blog"로 설정합니다.
public class JaesukBlog {

    @Id // 이 필드가 기본 키임을 나타냅니다.
    @Column(name = "blog_no") // 데이터베이스 컬럼 "blog_no"와 매핑됩니다.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본 키 생성을 데이터베이스에 위임합니다. (AUTO_INCREMENT)
    private int blogNo; // Integer와의 차이는 기본형(int)은 null 값을 가질 수 없지만, Integer는 null을 가질 수 있습니다.

    @Column(name = "blog_title", unique = true, nullable = false) // 데이터베이스 컬럼 "blog_title"과 매핑됩니다. 고유하며, null 값을 가질 수 없습니다.
    private String blogTitle;

    @Column(name = "blog_content", nullable = false, length = 5000) // 데이터베이스 컬럼 "blog_content"와 매핑됩니다. 최대 길이가 5000이고, null 값을 가질 수 없습니다.
    private String blogContent;

    @Column(name = "creation_date") // 데이터베이스 컬럼 "creation_date"와 매핑됩니다.
    @Temporal(TemporalType.TIMESTAMP) // 날짜와 시간을 함께 저장합니다.
    private Date createDate;

    // 기본 생성자
    public JaesukBlog() {
    }

    // 매개변수를 가지는 생성자
    public JaesukBlog(int blogNo, String blogTitle, String blogContent, Date createDate) {
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

    // 객체를 문자열로 표현하는 메서드 (디버깅용)
    @Override
    public String toString() {
        return "JaesukBlog{" +
                "blogNo=" + blogNo +
                ", blogTitle='" + blogTitle + '\'' +
                ", blogContent='" + blogContent + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
