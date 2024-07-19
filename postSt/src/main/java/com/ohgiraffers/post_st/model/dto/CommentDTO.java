package com.ohgiraffers.post_st.model.dto;

public class CommentDTO {

//    private Long id;

    private String content;

    private Long blogid;

    public CommentDTO() {
    }

    public CommentDTO(String content, Long blogid) {
        this.content = content;
        this.blogid = blogid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getBlogid() {
        return blogid;
    }

    public void setBlogid(Long blogid) {
        this.blogid = blogid;
    }

    @Override
    public String toString() {
        return "CommentDTO{" +
                "content='" + content + '\'' +
                ", blogid=" + blogid +
                '}';
    }
}
