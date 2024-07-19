package com.ohgiraffers.post_st.model.entity;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "jun_blog")
public class JunBlog {
    // 데이터베이스 테이블과 매핑되는 클래스입니다. 데이터베이스의 구조를 반영하며,
    // 주로 JPA(Java Persistence API)를 사용해 정의됩니다.

    @Id
    @Column(name = "blog_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "blog_title", unique = true, nullable = false)
    private String blogTitle;

    @Column(name = "blog_content", nullable = false, length = 5000)
    private String blogContent;

    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Column(name = "blog_like", nullable = false, columnDefinition = "INT DEFAULT 0")
    private int like;

//     블로그와 댓글 간의 일대다 관계를 정의합니다.
//     하나의 블로그 게시글에는 여러 개의 댓글이 달릴 수 있기 떄문에
//     mappedBy: 반대편 엔티티에서 이 관계를 소유하고 있는 필드의 이름을 지정
//     cascade: 부모 에니티에서 수행된 작업이 자식 엔티티에 어떻게 전파되는지를 정의 (종류 많아서 쓸때 찾아보기)

    public JunBlog() {
    }

    public JunBlog(Long id, String blogTitle, String blogContent, Date createDate, int like) {
        this.id = id;
        this.blogTitle = blogTitle;
        this.blogContent = blogContent;
        this.createDate = createDate;
        this.like = like;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    @Override
    public String toString() {
        return "JunBlog{" +
                "id=" + id +
                ", blogTitle='" + blogTitle + '\'' +
                ", blogContent='" + blogContent + '\'' +
                ", createDate=" + createDate +
                ", like=" + like +
                '}';
    }
}
