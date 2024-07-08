package com.ohgiraffers.post_st.controller;


import com.ohgiraffers.post_st.model.dto.JunBlogDTO;
import com.ohgiraffers.post_st.model.entity.JunBlog;
import com.ohgiraffers.post_st.service.JunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/jun")     //이 클래스 내의 모든 메소드는 /jun으로 시작하는 URL에 매핑
public class JunController {

    // JunService 타입의 필드르 선언. 서비스 계층의 메소드를 호출하기 위해 사용됨
    // 'private final'로 선언해서 반드시 초기화 해야되고(생성자에서), 변경할 수 없음
    private final JunService junService;

    // JunService의 인스턴스를 주입함
    // 스프링이 JunController를 생성할 때, JunService의 구현체를 자동으로 주입함
    @Autowired
    // 생성자 주입 방식으로 'JunService'타입의 객체를 주입받음. 스프링 컨테이너가 'JunController'객체를 생성할 때, 'JunService'타입의 빈을 찾아 생성자의 매개변수로 주입
    public JunController(JunService junService) {
        // 주입된 JunService 인스턴스를 클래스 필드에 할당하여 초기화함
        this.junService = junService;
    }

    //GET 요청을 처리하도록 매핑. /main 을 요청하면 이 메소드가 호출됨
    @GetMapping("/main")
    public String mainpage() {
        return "/jun/main";   // (1) /jun안붙여서 오류 경로 정확히 쓰기
    }

    @GetMapping("/post")
    public String showPostForm() {
        return "/jun/post";
    }



    @GetMapping("//post-detail/{blogid}")
    public String showdetailpost(){
        return "/jun/post-detail";
    }



    // 게시물을 등록하는 부분
    @PostMapping
    // JunBlogDTO와 ModelAndView 객체를 매개변수로 받음 반환타입은 ModelAndView
    // 데이터 전송객체 JunBlogDTO, 요청 파라미터를 junBlogDTO에 바인딩
    public ModelAndView postBlog(JunBlogDTO junBlogDTO, ModelAndView mv){
        // 블로그 제목이 null이거나 빈 문자열인 경우 리다이렉트
        if(junBlogDTO.getBlogTitle() == null || junBlogDTO.getBlogTitle().equals("")){
            mv.setViewName("redirect:/jun/post");
        }
        // 블로그 내용이 null이거나 빈 문자열인 경우 리다이렉트
        if(junBlogDTO.getBlogContent() == null || junBlogDTO.getBlogContent().equals("")){
            mv.setViewName("redirect:/jun/post");
        }
        // 서비스 클래스의 post 메서드를 호출하여 블로그 게시글을 저장하고 결과를 받음
        int result = junService.post(junBlogDTO);
        // 결과가 0 이하인 경우 에러 페이지로 이동
        if(result <= 0){
            mv.setViewName("error/page");
        } else {
            // 결과가 양수인 경우 성공 페이지로 이동
            mv.setViewName("jun/post");
        }
        // ModelAndView 객체를 반환합니다.
        return mv;
    }
    // 작성된 글 목록을 보여주는 부분
    @GetMapping("/post-list")
    public String getBlogList(Model model) {
        // JunService를 통해 모든 블로그 게시글을 가져옴
        List<JunBlog> blogList = junService.getAllBlogs();
        // Model 객체에 "blogList"라는 이름으로 가져온 블로그 목록을 추가
        model.addAttribute("blogList", blogList);
        // 뷰 이름을 반환함. 여기서는 "/jun/post-list"를 반환하여 해당 뷰를 표시하도록 함
        return "/jun/post-list";
    }

    // 글 상세조회
    // 1. 게시물 리스트에서 글 보기 버튼 추가
    // 2. 버튼을 누르면 작성된 글 조회하는 페이지로 넘어감

    // 글 상세조회 메서드 추가
    @GetMapping("/post-detail/{blogid}")
    public String getBlogDetail(@PathVariable Long blogid, Model model) {
        // ID를 이용하여 해당 블로그 게시글을 조회
        JunBlog blog = junService.getBlogById(blogid);
        // 조회한 블로그 게시글을 모델에 추가
        model.addAttribute("blog", blog);
        // 상세조회 페이지로 이동
        return "/jun/post-detail";
    }





    // 작성된 글 수정
    // 1. 글 목록중에 수정하고싶은 게시물로 들어가기
    // 2. 글 수정 페이지 새로 만들기
    // 3. 작성된 글의 데이터를 가져오기
    // -글 작성 페이지 형식으로 돼있는데 작성한 글이 들어가있어야됨
    // 4.3에서 가져온 글을 수정하고 다시 저장
    // - 새로운 게시물로 저장되지않고 원래 있던 게시물에 저장돼야함

    // 작성된 글 삭제
    // 1. 삭제


    // 게시물 삭제 요청 처리
    @PostMapping("/jun/post-delete")
    public String postDelete(@RequestParam("blogid") Long blogId){
        junService.deletePost(blogId);
        return "redirect:/jun/post-list";
    }






}





