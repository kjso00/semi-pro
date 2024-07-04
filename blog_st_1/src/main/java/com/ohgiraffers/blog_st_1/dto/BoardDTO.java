package com.ohgiraffers.blog_st_1.dto;

import com.ohgiraffers.blog_st_1.domain.entity.Board;
import lombok.*;

import java.time.LocalDateTime;



@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardDTO {
    private int id;
    private String author;
    private String title;
    private String content;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public Board toEntity() {
        Board build = Board.builder()
                .id(id)
                .blog_author(author)
                .blog_title(title)
                .blog_content(content)
                .build();
        return build;
    }

    @Builder
    public BoardDTO(int id, String blog_author, String blog_title, String blog_content, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.id = id;
        this.author = blog_author;
        this.title = blog_title;
        this.content = blog_content;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }
}
