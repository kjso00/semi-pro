package com.ohgiraffers.post_st.model.dto;

public class CommentDTO {

    private String comment;

    private String reply;

    public CommentDTO() {
    }

    public CommentDTO(String comment, String reply) {
        this.comment = comment;
        this.reply = reply;
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

    @Override
    public String toString() {
        return "CommentDTO{" +
                "comment='" + comment + '\'' +
                ", reply='" + reply + '\'' +
                '}';
    }
}
