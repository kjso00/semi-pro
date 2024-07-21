package com.ohgiraffers.blogpar.blog.repository;


import com.ohgiraffers.blogpar.blog.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
}
