package com.ohgiraffers.blog.jaesuk.service;

import com.ohgiraffers.blog.jaesuk.model.dto.BlogDTO;
import com.ohgiraffers.blog.jaesuk.model.entity.JaesukBlog;
import com.ohgiraffers.blog.jaesuk.repository.JeasuckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class JeasukService {

    private final JeasuckRepository jeasuckRepository;

    @Autowired
    public JeasukService(JeasuckRepository jeasuckRepository) {
        this.jeasuckRepository = jeasuckRepository;
    }

    @Transactional
    public int post(BlogDTO blogDTO) {
        // 1. 모든 JaesukBlog 엔티티를 데이터베이스에서 조회
        List<JaesukBlog> jaesukBlogs = jeasuckRepository.findAll();

        // 2. 도메인 로직: 같은 제목의 블로그 글이 이미 존재하는지 확인
        for (JaesukBlog blog: jaesukBlogs) {
            if(blog.getBlogTitle().equals(blogDTO.getBlogTitle())){
                return 0; // 이미 존재하는 경우 0을 반환하고 메서드 종료
            }
        }

        // 3. 새로운 JaesukBlog 엔티티 생성 및 저장
        JaesukBlog saveBlog = new JaesukBlog();
        saveBlog.setBlogContent(blogDTO.getBlogContent());
        saveBlog.setBlogTitle(blogDTO.getBlogTitle());
        saveBlog.setCreateDate(new Date());
        JaesukBlog result  = jeasuckRepository.save(saveBlog);

        // 4. 저장 결과에 따라 반환할 값 설정
        int resultValue = 0;
        if(result != null){
            resultValue = 1; // 저장 성공 시 1을 반환
        }

        return resultValue;
    }
}
