package com.ohgiraffers.blogpar.blog.controller;



import com.ohgiraffers.blogpar.blog.dto.BoardDTO;
import com.ohgiraffers.blogpar.blog.entity.BoardEntity;
import com.ohgiraffers.blogpar.blog.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/board")
public class BoardController {

    private BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }


    // 게시글 작성 페이지
   @GetMapping("/save")
    public String saveForm(){
       return "save";
   }

   // 게시글 등록
    // 1. 사용자가 입력 페이지에서 값을 입력하고 버튼을 눌러 컨트롤러에 요청을 전달 - form, post, action
    // 2. 컨트롤러에서 폼 데이터를 받아 값을 dto에 저장. 서비스에 전달해줌 save
    // 3. 서비스에서 컨트롤러로부터 받은 dto값을 엔티티로 변환 후 레포지토리로 전달
    // 4. 레포지토리에서 db에 접근하여 데이터를 저장.

   @PostMapping("/save")
   // @ModelAttribute를 사용하면 BoardDTO 객체를 찾아서 폼태그에서 정의한 name과 필드값이 동일하다면 ex)boardTitle
   // 필드에 대한 세터를 호출해서 페이지에서 입력한 값을 세터 메서드로 각각 담아줌
   // 일일히 RequestParam으로 받을 필요 없이 하나의 dto객체로만 받으면 됨
    public String save(@ModelAttribute BoardDTO boardDTO){
        boardService.save(boardDTO);
       return "index";
   }

   // 게시글 목록
    // 1. 레포지토리를 통해 db에 저장돼있던 모든 게시글을 엔티티 형식으로 가져옴
    // 2. 서비스에서 가져온 엔티티를 DTO로 변환해 컨트롤러에 전달
    // 3. 서비스에서 전달받은 값을 사용자 화면에 전달
    // 4. 반복문을 사용하여 게시글들을 나열

    // DB에서 전체 게시글 데이터를 가져와서 board-list에 보여줌
   @GetMapping("/board-list")
   // 전체 목록을 db로 부터 가져와야 되기 때문에 모델 객체를 사용
    public String boardList(Model model){
        // 게시글은 하나가 아니라 여러개이기 때문에 BoardDTO객체가 담겨있는 List타입을 사용
        List<BoardEntity> boardList= boardService.getAllBoards();
        // 가져온 데이터를 모델 객체에 담아야됨
       model.addAttribute("boardList", boardList);
        return "board-list";
   }


}
