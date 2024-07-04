package com.ohgiraffers.blog_st_1.domain.entity;


import jakarta.persistence.*;


import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Entity

@EntityListeners(AuditingEntityListener.class) /* JPA에게 해당 Entity는 Auditiong 기능을 사용함을 알립니다. */
public class Board {

    @Id
    @GeneratedValue
    private int id;

    @Column(length = 10, nullable = false)
    private String blog_author;

    @Column(length = 100, nullable = false)
    private String blog_title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String blog_content;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;

    public Board() {
    }

    @Builder
    public Board(int id, String blog_author, String blog_title, String blog_content) {
        this.id = id;
        this.blog_author = blog_author;
        this.blog_title = blog_title;
        this.blog_content = blog_content;
    }
}

