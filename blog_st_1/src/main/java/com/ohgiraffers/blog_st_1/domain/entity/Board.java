package com.ohgiraffers.blog_st_1.domain.entity;


import jakarta.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import java.util.Date;

@Entity
@Table(name = "jun_post")
@EntityListeners(AuditingEntityListener.class) /* JPA에게 해당 Entity는 Auditiong 기능을 사용함을 알립니다. */
public class Board {

    @Id
    @Column(name = "blog_no") // 컬럼 이름 매핑
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본 키 생성을 데이터베이스에 위임 (AUTO_INCREMENT)
    private int blogNo;

    @Column(name = "blog_title", unique = true, nullable = false) // 블로그 제목 컬럼, 유니크 제약 조건 및 널 허용 안 함
    private String blogTitle;

    @Column(name = "blog_content", nullable = false, length = 5000) // 블로그 내용 컬럼, 널 허용 안 하며 최대 길이 5000
    private String blogContent;

    @Column(name = "blog_createdDate") // 생성일 컬럼
    @Temporal(TemporalType.TIMESTAMP) // 날짜와 시간을 지정
    private Date createDate;

    public Board() {
    }

    public Board(int blogNo, String blogTitle, String blogContent, Date createDate) {
        this.blogNo = blogNo;
        this.blogTitle = blogTitle;
        this.blogContent = blogContent;
        this.createDate = createDate;
    }

    public int getBlogNo() {
        return blogNo;
    }

    public void setBlogNo(int blogNo) {
        this.blogNo = blogNo;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Board{" +
                "blogNo=" + blogNo +
                ", blogTitle='" + blogTitle + '\'' +
                ", blogContent='" + blogContent + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
