package com.ohgiraffers.post_st.model.entity;


import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table(name="comment_table")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    @NotNull
    private String comment;

    @Column(length = 500)
    private String reply = "";

    private Long blog_id = 0L;


    public Comment() {
    }

    public Comment(Long id, String comment, String reply, Long blog_id) {
        this.id = id;
        this.comment = comment;
        this.reply = reply;
        this.blog_id = blog_id;
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

    public Long getBlog_id() {
        return blog_id;
    }

    public void setBlog_id(Long blog_id) {
        this.blog_id = blog_id;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", reply='" + reply + '\'' +
                ", blog_id=" + blog_id +
                '}';
    }
}
