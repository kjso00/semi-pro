package com.ohgiraffers.post_st.repository;

import com.ohgiraffers.post_st.model.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogCommentRepository extends JpaRepository<Comment, Long> {

}
