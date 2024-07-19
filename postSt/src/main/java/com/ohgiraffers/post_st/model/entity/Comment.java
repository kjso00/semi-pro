package com.ohgiraffers.post_st.model.entity;


import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import java.util.Date;

@Entity
@Table(name= "jun_comment")
public class Comment {

    @Id
    @Column(name= "comment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comid;

    @NonNull
    @Column(name = "content", nullable = false, length = 1000)
    private String content;

    @Column(name = "blog_ID")
    private Long blogId;

//    @Column(name = "blog_id", nullable = false)
//    private Long blogId;

    public Comment() {
    }

    public Comment(Long comid, String content, Long blogId) {
        this.comid = comid;
        this.content = content;
        this.blogId = blogId;
    }

    public Long getComid() {
        return comid;
    }

    public void setComid(Long comid) {
        this.comid = comid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "comid=" + comid +
                ", content='" + content + '\'' +
                ", blogId=" + blogId +
                '}';
    }
}
