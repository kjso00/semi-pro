package com.ohgiraffers.post_st.controller;

import com.ohgiraffers.post_st.model.entity.JunBlog;
import com.ohgiraffers.post_st.service.JunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

