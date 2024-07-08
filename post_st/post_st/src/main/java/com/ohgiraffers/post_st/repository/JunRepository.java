package com.ohgiraffers.post_st.repository;

import com.ohgiraffers.post_st.model.entity.JunBlog;
import org.springframework.data.jpa.repository.JpaRepository;

    // JpaRepository 인터페이스를 선언, JunBlog 엔티티를 관리하고, 기본 키의 타입은 Integer
public interface JunRepository extends JpaRepository<JunBlog, Long> {

        void deleteById(Long id);
}
