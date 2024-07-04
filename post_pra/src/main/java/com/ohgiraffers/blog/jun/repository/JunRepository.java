package com.ohgiraffers.blog.jun.repository;


import com.ohgiraffers.blog.jun.model.entity.JunBlog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JunRepository extends JpaRepository<JunBlog, Integer> {



    // JpaRepository를 상속받아 기본적인 CRUD 기능을 제공.
    // 제네릭 타입으로 JunBlog 엔티티와 기본 키 타입인 Integer를 지정
}

// JunBlog 엔티티를 위한 데이터 접근 레이어를 정의
// JpaRepository를 상속받아 기본적인 CRUD(생성, 조회, 업데이트, 삭제) 기능을 제공합니다.

// JpaRepository<JunBlog, Integer>: JpaRepository를 상속받아 JunBlog 엔티티와
// 기본 키 타입인 Integer를 지정합니다. 이로써 Spring Data JPA가 제공하는 여러 메서드를 사용할 수 있습니다.
