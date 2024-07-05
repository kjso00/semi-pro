package com.ohgiraffers.blog.jun.service;


// JunService 클래스는 블로그 게시물과 관련된 비즈니스 로직을 처리하는 서비스 클래스

import com.ohgiraffers.blog.jun.model.dto.BlogDTO;
import com.ohgiraffers.blog.jun.model.entity.JunBlog;
import com.ohgiraffers.blog.jun.repository.JunRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class JunService {

    private final JunRepository junRepository;

    // 생성자 주입을 통해 JunRepository를 인스턴스 변수에 할당
    @Autowired
    public JunService(JunRepository junRepository) {
        this.junRepository = junRepository;
    }

    // 트랜잭션을 관리하는 메서드로, 블로그 게시물을 등록
    @Transactional
    public int post(BlogDTO blogDTO) {
        // 모든 블로그 게시물을 조회
        List<JunBlog> junBlogs = junRepository.findAll();

        // 블로그 제목이 중복되는지 확인하는 도메인 로직
        for (JunBlog blog : junBlogs) {
            if (blog.getBlogTitle().equals(blogDTO.getBlogTitle())) {
                return 0; // 중복되는 제목이 있으면 0을 반환하여 등록 실패를 나타냄
            }
        }

        // 새로운 블로그 객체를 생성하여 데이터를 설정
        JunBlog saveBlog = new JunBlog();
        saveBlog.setBlogContent(blogDTO.getBlogContent());
        saveBlog.setBlogTitle(blogDTO.getBlogTitle());
        saveBlog.setCreateDate(new Date());

        // 새로운 블로그 객체를 저장
        JunBlog result = junRepository.save(saveBlog);

        // 결과값을 초기화
        int resultValue = 0;

        // 저장된 객체가 null이 아니면 1을 반환하여 등록 성공을 나타냄
        if (result != null) {
            resultValue = 1;
        }

        return resultValue; // 등록 결과를 반환
    }

    public List<JunBlog> getAllBlogs() {
        return junRepository.findAll();
    }










}

// 게시물과 관련된 비즈니스 로직을 처리
// post 메서드는 블로그 게시물을 등록하며, 블로그 제목이 중복되는지 확인한 후, 중복되지 않으면 새로운 블로그 게시물을 저장
// 트랜잭션 관리를 통해 데이터 일관성을 유지
