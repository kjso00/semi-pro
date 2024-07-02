package com.ohgiraffers.blog.jun.controller;


import com.ohgiraffers.blog.jun.model.dto.BlogDTO;
import com.ohgiraffers.blog.jun.model.entity.JunBlog;
import com.ohgiraffers.blog.jun.repository.JunRepository;
import com.ohgiraffers.blog.jun.service.JunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/jun") // 이 클래스의 모든 메서드는 "/jun" URL에 매핑된 요청을 처리
public class JunController {

    private final JunService junService;
    private final JunRepository junRepository;

    // 생성자 주입을 통해 JunService를 인스턴스 변수에 할당
    @Autowired
    public JunController(JunService junService, JunRepository junRepository) {
        this.junService = junService;
        this.junRepository = junRepository;
    }

    // GET 요청을 처리해서 "jun/page" 뷰를 반환
    @GetMapping
    public String indexJUN() {
        return "jun/page";
    }

    //POST 요청을 처리하여 블로그 게시물을 등록
    @PostMapping
    public ModelAndView postBlog(BlogDTO blogDTO, ModelAndView mv) {

        //블로그 제목이 비어있는 경우 리다이렉트
        if (blogDTO.getBlogTitle() == null || blogDTO.getBlogTitle().equals("")) {
            mv.setViewName("redirect:jun");
        }
        // 블로그 내용이 비어있는 경우 리다이렉트
        if (blogDTO.getBlogContent() == null || blogDTO.getBlogContent().equals("")) {
            mv.setViewName("redirect:jun");
        }
        // 블로그 게시물을 등록하고 결과를 확인
        int result = junService.post(blogDTO);

        //등록에 실패한 경우 에러 페이지로 이동
        if (result <= 0) {
            mv.setViewName("error/page");
        } else {
            // 성공한 경우 "jun/page" 뷰로 이동
            mv.setViewName("jun/page");
        }
        return mv;
    }

    @GetMapping("/")
    public String showBlogForm(Model model) {
        model.addAttribute("jun", "/save");
        return "blog-form";
    }

    @PostMapping("/jun")  // /save
    public String saveBlog(@RequestParam("blogTitle") String blogTitle,
                           @RequestParam("blogContent") String blogContent) {
        JunBlog junBlog = new JunBlog();
        junBlog.setBlogTitle(blogTitle);
        junBlog.setBlogContent(blogContent);
        junRepository.save(junBlog);
        return "redirect:/";
    }
}

// 이 코드는 JeasuckController 클래스로, 블로그 게시물 관리를 위한 Spring MVC 컨트롤러입니다.
// /jaesuck URL로 들어오는 요청을 처리하며, indexJaesuck 메서드는 GET 요청에 대해
// "jaesuck/page" 뷰를 반환합니다. postBlog 메서드는 POST 요청을 처리하며, 블로그 제목과 내용
// 이 비어있지 않은지 확인한 후, 게시물 등록을 시도합니다. 등록 성공 여부에 따라 뷰를 설정하여 반환합니다.
