package com.ohgiraffers.post_st.controller;


import com.ohgiraffers.post_st.model.dto.CommentDTO;
import com.ohgiraffers.post_st.model.dto.JunBlogDTO;
import com.ohgiraffers.post_st.model.entity.Comment;
import com.ohgiraffers.post_st.model.entity.JunBlog;
import com.ohgiraffers.post_st.service.JunService;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/jun")     //이 클래스 내의 모든 메소드는 /jun으로 시작하는 URL에 매핑
public class JunController {

    // 클라이언트의 요청을 처리하고, 적절한 서비스 메서드를 호출하여 결과를 반환합니다.
    // 주로 HTTP 요청/응답을 처리

    // JunService 타입의 필드르 선언. 서비스 계층의 메소드를 호출하기 위해 사용됨
    // 'private final'로 선언해서 반드시 초기화 해야되고(생성자에서), 변경할 수 없음
    // JunService 타입의 junService라는 멤버 변수를 선언
    private final JunService junService;

    // JunService의 인스턴스를 주입함
    // 스프링이 JunController를 생성할 때, JunService의 구현체를 자동으로 주입함

    // private final JunService junService;로 변수를 선언하고
    // @Autowired로 변수를 초기화한다고 생각하면됨

    @Autowired
    // 생성자 주입 방식으로 'JunService'타입의 객체를 주입받음. 스프링 컨테이너가 'JunController'객체를 생성할 때, 'JunService'타입의 빈을 찾아 생성자의 매개변수로 주입
    public JunController(JunService junService) {
        // 주입된 JunService 인스턴스를 클래스 필드에 할당하여 초기화함
        // this.junService: 이 객체의 필드, junService: 메서드의 매개변수로 전달된 junService
        // 메서드 내에서 전달된 인자(parameter)를 가리키며, 해당 메서드 내에서만 유효한 변수
        this.junService = junService;
    }

    //GET 요청을 처리하도록 매핑. /main 을 요청하면 이 메소드가 호출됨
    @GetMapping("/main")
    public String mainpage() {
        // /jun/main 페이지를 찾아 값을 반환
        return "/jun/main";   // (1) /jun안붙여서 오류 경로 정확히 쓰기
    }
    // /main요청을 날리면 /jun/main을 반환해줌

    //게시물 작성 폼
    @GetMapping("/post")
    public String showPostForm() {
        return "/jun/post";
    }

//("/jun/post-detail/{id}/comment")
    @PostMapping("/post-detail/{id}}")
    // @PathVariable Long id: url 경로에서 {id} 부분의 값을 추출하여 메서드 매개변수 'id'에 매핑.
    // 이 값은 댓글이 달릴 특정 블로그 게시물의 ID
    // @ModelAttribute CommentDTO commentDTO: 요청 파라미터를 'CommentDTO' 객체에 매핑.
    // 폼 데이터가 자동으로 'CommentDTO'객체에 바인딩
    public String postComment(@PathVariable Long id, @ModelAttribute CommentDTO commentDTO, Model model) {

//        if (id == null || id <= 0) {
//
//            return "redirect:/jun/post-list";
//        }

        // 댓글 코멘트가 null이거나 빈 문자열이면 /jun/post-detail/{id} 페이지로 리다이렉트
        if (commentDTO.getContent() == null || commentDTO.getContent().trim().isEmpty()) {

            return "redirect:/jun/post-detail/" + id;
        }
        // 댓글 등록
        commentDTO.setBlogid(id);  // 댓글이 달릴 블로그 ID 설정
        int result1 = junService.addComment(commentDTO);

        if (result1 <= 0) {
            return "redirect:/jun/post-list";
        }else{
            // 댓글 목록 페이지로
            return "redirect:/jun/comment-list";
        }

    }

    @GetMapping("/comment-list")
    public String viewPostWithComments(@PathVariable Long id, Model model) {
        // 블로그 게시물의 댓글을 가져옵니다
        List<Comment> comments = junService.getCommentsByBlogId(id);

        // 댓글 목록을 모델에 추가합니다
        model.addAttribute("comments", comments);

        // 블로그 게시물 정보도 모델에 추가합니다 (추가로 구현된 경우)
        // JunBlog blog = blogService.getBlogById(id); // 블로그 정보 추가
        // model.addAttribute("blog", blog);

        // 뷰 이름을 반환합니다 (뷰 파일이 `post-detail.html`이라고 가정)
        return "/jun/comment-list";
    }


    // 게시물을 등록하는 부분
    @PostMapping
    // 게시물 작성 폼을 통해 전송한 데이터를 'JunBlogDTO' 객체에 자동으로 매핑
    // 'postBlog' 메소드가 호출될 때, 'JunBlogDTO' 객체는 폼 데이터로 초기화된 상태로 전달
    public ModelAndView postBlog(JunBlogDTO junBlogDTO, ModelAndView mv) {
        // 유효성 검사
        // 블로그 제목이 null이거나 빈 문자열인 경우 리다이렉트
        // 'junBlogDTO'객체의 'blogTitle' 필드를 가져옴, 'blogTitle' 필드가 'null'인지 확인,
        // or 제목이 빈 문자열인 경우 전체 조건이 참이됨
        // 위 조건이 참이면 /jun/post로 리다이렉트
        if (junBlogDTO.getBlogTitle() == null || junBlogDTO.getBlogTitle().equals("")) {
            mv.setViewName("redirect:/jun/post");
        }
        // 블로그 내용이 null이거나 빈 문자열인 경우 리다이렉트
        if (junBlogDTO.getBlogContent() == null || junBlogDTO.getBlogContent().equals("")) {
            mv.setViewName("redirect:/jun/post");
        }
        // 서비스 클래스의 post 메서드를 호출하여 블로그 게시글을 저장하고 결과를 받음
        int result = junService.post(junBlogDTO);
        // 결과가 0 이하인 경우 에러 페이지로 이동
        if (result <= 0) {
            mv.setViewName("error/page");
        } else {
            // 결과가 양수인 경우 성공 페이지로 이동
            // 글 등록하면 바로 목록 페이지로 이동하려고 했는데 이렇게 하면 데이터가 안불러와짐. 왜그럴까

            mv.setViewName("jun/post");
        }
        // ModelAndView 객체를 반환합니다.
        return mv;
    }

    // 글 목록
    // "/post-list"로 url 요청을 날림
    @GetMapping("/post-list")
    public String getBlogList(Model model) {
        // JunService를 통해 모든 블로그 게시글을 가져옴
        // junService.getAllBlogs()를 호출하여 모든 블로그 게시글을 DB에서 가져옴
        // 가져온 게시글 목록을 blogList에 저장
        List<JunBlog> blogList = junService.getAllBlogs();
        // Model 객체에 "blogList"라는 이름으로 가져온 블로그 목록을 추가
        model.addAttribute("blogList", blogList);
        // 뷰 이름을 반환함. 여기서는 "/jun/post-list"를 반환하여 해당 뷰를 표시하도록 함
        return "/jun/post-list";
    }

    // 글 상세조회
    // 1. 게시물 리스트에서 글 보기 버튼 추가
    // 2. 버튼을 누르면 작성된 글 조회하는 페이지로 넘어감

    // 글 상세조회

    // {blogid}는 경로 변수(path variable)로, URL에서 가변적인 값을 나타냅
    @GetMapping("/post-detail/{blogid}")
    // @PathVariable로 url 경로에서 추출한 blogid 값을 메서드의 매개변수로 받음
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

    @GetMapping("/post-edit")
    public String showUpdateForm(@RequestParam("id") Long id, Model model) {
        JunBlog blog = junService.getBlogById(id);
        JunBlogDTO blogDTO = new JunBlogDTO();
        blogDTO.setId(blog.getId());
        blogDTO.setBlogTitle(blog.getBlogTitle());
        blogDTO.setBlogContent(blog.getBlogContent());
        model.addAttribute("junBlogDTO", blogDTO);
        return "/jun/post-edit";
    }



    @PostMapping("/update")
    public String updatePost(@ModelAttribute("junBlogDTO") JunBlogDTO junBlogDTO) {
        JunBlog updatedPost = junService.updatePost(junBlogDTO);
        // 수정 성공 시, 수정된 게시물 상세 페이지로 리다이렉트
        return "redirect:/jun/post-detail/" + updatedPost.getId();
    }

    // 게시글 삭제

    // 1. 게시물 목록 페이지에서 등록된 게시물 옆에 삭제 버튼을 누르면 게시물이 삭제되는 기능
    // 2. 삭제 버튼을 누르면 해당 id의 게시물의 데이터가 데이터베이스에서 삭제되고
    // 3. 게시물 목록에서도 없어져야됨

    @PostMapping("/delete/{id}")
    public String deleteBlog(@PathVariable Long id) {
        junService.deleteBlog(id);
        return "redirect:/jun/post-list";
    }
}

//    // 댓글 작성
//    @PostMapping("/jun/post-detail/{id}/comment")
//    // @PathVariable Long id: url 경로에서 {id} 부분의 값을 추출하여 메서드 매개변수 'id'에 매핑.
//    // 이 값은 댓글이 달릴 특정 블로그 게시물의 ID
//    // @ModelAttribute CommentDTO commentDTO: 요청 파라미터를 'CommentDTO' 객체에 매핑.
//    // 폼 데이터가 자동으로 'CommentDTO'객체에 바인딩
//    public String postComment(@PathVariable Long id, @ModelAttribute CommentDTO commentDTO , Model model) {}











//     좋아요 기능
//     1. 컨트롤러에 게시글 id 전달 - @@PathVariable
// 좋아요 기능 fetch api 사용해서 비동기 방식으로 바꾸기



//    댓글창
//
//            필드
//----------------------------------------------------------------------------------------------------------------------
//    댓글 id
//    댓글 comment
//    대댓글 id
//    간략한 순서
//----------------------------------------------------------------------------------------------------------------------
//        [댓글 등록]
//            1. 댓글 입력창에 내용 입력
//2. 입력이 끝나면 등록 버튼을 눌러서 form, action-(댓글등록url), method-(post), submit으로 url 요청을 날림
//--------------------------------------------------------------------------------------------------------------------뷰
//3. 요청을 받은 컨트롤러에서 post 메서드에 의해서 DTO에 입력값을 저장 서비스에 전달
/////[1] 게시글 ID가 존재하는지///
//[2] comment값이 null인지 or 빈 문자열인지 검사
//      -> 위 조건에 해당되면 리다이렉트
//---------------------------------------------------------------------------------------------------------------컨트롤러
//4. 컨트롤러에서 전달받은 DTO 값을 엔티티로 변환하고 레포지토리로 전달  - save
//[1] 같은 내용의 댓글을 달았는지 검사
//-----------------------------------------------------------------------------------------------------------------서비스
//
//5. 레포지토리를 통해 DB에 값을 저장
//
//[댓글 조회]
//
//            6. DB에 저장된 값을 불러오고 - getAll
//7. 가져온 데이터에서 댓글을 조회 - findbyId
//---------------------------------------------------------------------------------------------------------------- 서비스
//
//8. 서비스에서 조회한 데이터를 가져옴 - get
//9. 컨트롤러에서 모델에 데이터를 담아 뷰로 전달 -  Model
//10. 뷰 이름 반환 - return
//
//-------------------------------------------------------------------------------------------------------------- 컨트롤러








