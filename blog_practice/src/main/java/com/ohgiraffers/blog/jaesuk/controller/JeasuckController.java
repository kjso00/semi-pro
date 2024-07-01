package com.ohgiraffers.blog.jaesuk.controller;

import com.ohgiraffers.blog.jaesuk.model.dto.BlogDTO;
import com.ohgiraffers.blog.jaesuk.service.JeasukService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller // 이 클래스가 Spring MVC의 컨트롤러임을 나타냅니다.
@RequestMapping("/jaesuck") // "/jaesuck" 경로로 들어오는 요청을 이 컨트롤러가 처리하도록 매핑합니다.
public class JeasuckController {

    private final JeasukService jeasukService;

    @Autowired // 생성자 주입을 통해 JeasukService 빈을 주입받습니다.
    public JeasuckController(JeasukService jeasukService) {
        this.jeasukService = jeasukService;
    }

    @GetMapping // HTTP GET 요청을 처리하는 메서드입니다.
    public String indexJaesuck() {
        return "jaesuck/page"; // "jaesuck/page" 뷰를 반환합니다.
    }

    @PostMapping // HTTP POST 요청을 처리하는 메서드입니다.
    public ModelAndView postBlog(BlogDTO blogDTO, ModelAndView mv) {

        // 블로그 제목이 비어 있는지 확인합니다.
        if(blogDTO.getBlogTitle() == null || blogDTO.getBlogTitle().equals("")) {
            mv.setViewName("redirect:jaesuck"); // 비어 있으면 "jaesuck" 페이지로 리다이렉트합니다.
        }
        // 블로그 내용이 비어 있는지 확인합니다.
        if(blogDTO.getBlogContent() == null || blogDTO.getBlogContent().equals("")) {
            mv.setViewName("redirect:jaesuck"); // 비어 있으면 "jaesuck" 페이지로 리다이렉트합니다.
        }
        int result = jeasukService.post(blogDTO); // 서비스 레이어를 호출하여 블로그 포스트를 저장합니다.
        if(result <= 0) {
            mv.setViewName("error/page"); // 저장에 실패하면 "error/page" 뷰를 반환합니다.
        } else {
            mv.setViewName("jaesuck/page"); // 저장에 성공하면 "jaesuck/page" 뷰를 반환합니다.
        }
        return mv; // ModelAndView 객체를 반환합니다.
    }
}
