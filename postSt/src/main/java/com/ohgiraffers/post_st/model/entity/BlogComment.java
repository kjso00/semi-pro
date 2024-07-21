package com.ohgiraffers.post_st.model.entity;


import jakarta.persistence.*;

@Entity
@Table(name="comment_table")
public class BlogComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String comment;

    @Column(length = 500, nullable = false)
    private String reply;

    @Column(name = "blog_id", nullable = false)
    private Long blogId; // 게시글 ID를 저장

    public BlogComment() {
    }

    public BlogComment(Long id, String comment, String reply, Long blogId) {
        this.id = id;
        this.comment = comment;
        this.reply = reply;
        this.blogId = blogId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    @Override
    public String toString() {
        return "BlogComment{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", reply='" + reply + '\'' +
                ", blogId=" + blogId +
                '}';
    }
}
