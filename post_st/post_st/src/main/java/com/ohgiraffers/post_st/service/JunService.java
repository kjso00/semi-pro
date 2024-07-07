package com.ohgiraffers.post_st.service;


import com.ohgiraffers.post_st.model.dto.JunBlogDTO;
import com.ohgiraffers.post_st.model.entity.JunBlog;
import com.ohgiraffers.post_st.repository.JunRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class JunService {

    // JunRepository 인터페이스를 구현한 빈을 주입받음
    private final JunRepository junRepository;

    @Autowired
    public JunService(JunRepository junRepository) {
        this.junRepository = junRepository;
    }

    // 메서드가 하나의 트랜잭션으로 실행되어야 함을 나타냄. 메서드 실행 중 발생할 수 있는 데이터베이스 관련 예외를 처리하고 롤백할 수 있다.
    @Transactional
    public int post(JunBlogDTO junblogDTO) {
        // 블로그 제목이 중복되는지 검사하기 위해 모든 블로그를 가져옵니다.
        // JunBlog 객체들로 구성된 리스트를 저장 junBlogs는 이 리스트를 가리키는 변수
        // junRepository 는 JunBlogRepository 타입의 인스턴스. JpaRepository<JunBlog, Integer>를 상속받음
        List<JunBlog> junBlogs = junRepository.findAll();

        // 도메인 로직: 블로그 제목이 이미 존재하는지 확인합니다.
        for (JunBlog blog: junBlogs) {
            if(blog.getBlogTitle().equals(junblogDTO.getBlogTitle())){
                // 이미 같은 제목의 블로그가 존재하면 0을 반환하여 실패를 알립니다.
                return 0;
            }
        }

        // 새로운 JaesukBlog 객체를 생성하고 DTO로부터 받은 데이터를 설정합니다.
        JunBlog saveBlog = new JunBlog();
        saveBlog.setBlogContent(junblogDTO.getBlogContent());
        saveBlog.setBlogTitle(junblogDTO.getBlogTitle());
        saveBlog.setCreateDate(new Date());

        // 새로운 블로그를 저장하고 저장 결과를 받습니다.
        JunBlog result  = junRepository.save(saveBlog);

        int resultValue = 0;

        // 저장 결과가 null이 아니면 성공적으로 저장되었음을 알리는 값을 설정합니다.
        if(result != null){
            resultValue = 1;
        }

        // 성공 여부를 나타내는 값을 반환합니다.
        return resultValue;
    }

    public List<JunBlog> getAllBlogs() {
        return junRepository.findAll();
    }
}
