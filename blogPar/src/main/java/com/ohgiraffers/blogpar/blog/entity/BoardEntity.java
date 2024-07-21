package com.ohgiraffers.blogpar.blog.entity;


import jakarta.persistence.*;

// DB의 테이블 역할을 하는 클래스
@Entity
@Table(name = "board_table")
public class BoardEntity {
    @Id // pk 컬럼 지정. 필수
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false) //크기 100, not null
    private String boardTitle;

    @Column(length = 500, nullable = false)
    private String boardContent;

    public BoardEntity() {
    }

    public BoardEntity(Long id, String boardTitle, String boardContent) {
        this.id = id;
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
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

    public String getBoardContent() {
        return boardContent;
    }

    public void setBoardContent(String boardContent) {
        this.boardContent = boardContent;
    }

    @Override
    public String toString() {
        return "BoardEntity{" +
                "id=" + id +
                ", boardTitle='" + boardTitle + '\'' +
                ", boardContent='" + boardContent + '\'' +
                '}';
    }
}
