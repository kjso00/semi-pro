package com.ohgiraffers.blog.jun.controller;

import com.ohgiraffers.blog.jun.model.dto.BlogDTO;
import com.ohgiraffers.blog.jun.model.entity.JunBlog;
import com.ohgiraffers.blog.jun.service.JunService;
import com.ohgiraffers.blog.jun.service.JunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/jun")
public class JunController {

    private final JunService junService;
    private BlogDTO currentBlog;

    @Autowired
    public JunController(JunService junService) {
        this.junService = junService;
    }

    @GetMapping
    public String jun() {
        return "/jun/page";
    }


    @GetMapping("/junpost")
    public String postPage(Model model) {
        if (currentBlog != null) {
            model.addAttribute("blogTitle", currentBlog.getBlogTitle());
            model.addAttribute("blogContent", currentBlog.getBlogContent());
        }
        return "jun/junpost";
    }

    @GetMapping("/junpost-list")
    public String getBlogList(Model model) {
        List<JunBlog> blogList = junService.getAllBlogs();
        model.addAttribute("blogList", blogList);
        return "/jun/junpost-list";
    }
    @GetMapping("/postupdate")
    public String updatePage(@RequestParam("blogTitle") String blogTitle, @RequestParam("blogContent") String blogContent, Model model) {
        model.addAttribute("blogTitle", blogTitle);
        model.addAttribute("blogContent", blogContent);
        return "jun/postupdate";
    }










    @PostMapping
    public ModelAndView postBlog(BlogDTO blogDTO, ModelAndView mv){

        if(blogDTO.getBlogTitle() == null || blogDTO.getBlogTitle().equals("")){
            mv.setViewName("redirect:/jun/post");
        }
        if(blogDTO.getBlogContent() == null || blogDTO.getBlogContent().equals("")){
            mv.setViewName("redirect:jun/post");
        }

        int result = junService.post(blogDTO);

        if(result <= 0){
            mv.setViewName("error/page");
        }else{
            currentBlog = blogDTO;
            mv.setViewName("redirect:/jun/junpost");
        }
        return mv;
    }

    @GetMapping("/review")
    public String share() {
        return "/review";
    }


}


// 메인화면 -> 글 작성 페이지 -> 작성된 글 표시   // 글 목록 화면 연결 안됨
//
//
//
//메인화면
//->글 목록 화면
//-홈 버튼 추가
//- 게시물 목록에서 게시물 등록, 수정, 삭제 기능
//-등록
//-> 글 작성 페이지
//
//
//root계정으로
//
//mysql 설정할때 root
//
//
//    url: jdbc:mysql://localhost:3306/gangnam
//    username: gangnam
//    password: gangnam
//    driver-class-name: com.mysql.cj.jdbc.Driver
//
//위에 세개만 그대로

