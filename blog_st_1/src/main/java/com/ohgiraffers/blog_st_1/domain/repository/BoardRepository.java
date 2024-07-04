package com.ohgiraffers.blog_st_1.domain.repository;

import com.ohgiraffers.blog_st_1.domain.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Integer> {
}
