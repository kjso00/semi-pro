package com.ohgiraffers.post_st.controller;

import com.ohgiraffers.post_st.model.entity.JunBlog;
import com.ohgiraffers.post_st.service.JunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

// @Controller와 @RestController의 주요 차이점- Response Body가 생성되는 방식
// @Controller는 주로 View를 반환하기 위해 사용

// @RestController는
// 비동기 통신에서 쓰이는 Body 안의 데이터(JSON객체)를 자바 객체(VO)를
// 데이터(JSONRORCP)로 바꿔 Body 안에 넣어주는 어노테이션

// @Controller로 Data를 반활할 경우
// 데이터를 반환하기 위해  ResponseEntity(HttpStatus + HttpHeaders + HttpBody 형태의 데이터,
// 한 마디로 Http 응답 메시지)의 Body(Response Body)를 사용해야 하는데
// 이 때 @ReoponsBody 어노테이션을 사용하면됨
// REST API를 개발할 때 주로 사용 ResponseEntity로 감싸서 반환

// Response Entity란
// HttpEntity를 상속받아 구현한 클래스
// HttpEntity란? http 요청 혹은 응답에 해당하는 httpHeader와 httpBody를 포함하는 클래스
@RestController
public class LikeRestController {

    private JunService junService;

    @Autowired
    public LikeRestController(JunService junService) {
        this.junService = junService;
    }

    @PostMapping("/jun/post-detail/{id}/like")
    public ResponseEntity<?> likePost(@PathVariable Long id, Model model) {
        // 2. id를 서비스에 전달  - id
        JunBlog blog = junService.likeBlog(id);
        // 8. 전달받은걸 화면에 반환 - model
        return ResponseEntity.ok(blog);
    }

    @PostMapping("/jun/post-detail/{id}/unlike")
    public ResponseEntity<?> unlikePost(@PathVariable Long id, Model model) {
        JunBlog blog = junService.unlikeBlog(id);
        return ResponseEntity.ok(blog);
    }
}

