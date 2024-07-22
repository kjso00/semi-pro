package com.ohgiraffers.blogpar.blog.dto;

//DTO(Data Transfer Object) , VO, Bean
public class BoardDTO {

    private String boardTitle;
    private String boardContents;

    public BoardDTO() {
    }

    public BoardDTO(String boardTitle, String boardContents) {
        this.boardTitle = boardTitle;
        this.boardContents = boardContents;
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
                "boardTitle='" + boardTitle + '\'' +
                ", boardContents='" + boardContents + '\'' +
                '}';
    }
}
