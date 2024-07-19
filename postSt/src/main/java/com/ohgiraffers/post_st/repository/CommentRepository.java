package com.ohgiraffers.post_st.repository;

import com.ohgiraffers.post_st.model.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// Comment 엔티티를 다루고 Comment는 데이터베이스에서 관리할 객체의 타입
// Long: Comment 엔티티의 id 필드의 타입
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
