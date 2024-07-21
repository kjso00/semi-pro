package com.ohgiraffers.blogpar.blog.dto;

//DTO(Data Transfer Object) , VO, Bean
public class BoardDTO {
    private Long id;
    private String boardTitle;
    private String boardContents;

    public BoardDTO() {
    }

    public BoardDTO(Long id, String boardTitle, String boardContents) {
        this.id = id;
        this.boardTitle = boardTitle;
        this.boardContents = boardContents;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBoardTitle() {
        return boardTitle;
    }

    public void setBoardTitle(String boardTitle) {
        this.boardTitle = boardTitle;
    }

    public String getBoardContents() {
        return boardContents;
    }

    public void setBoardContents(String boardContents) {
        this.boardContents = boardContents;
    }

    @Override
    public String toString() {
        return "BoardDTO{" +
                "id=" + id +
                ", boardTitle='" + boardTitle + '\'' +
                ", boardContents='" + boardContents + '\'' +
                '}';
    }
}
