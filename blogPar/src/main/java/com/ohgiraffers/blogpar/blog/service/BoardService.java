package com.ohgiraffers.blogpar.blog.service;


import com.ohgiraffers.blogpar.blog.dto.BoardDTO;
import com.ohgiraffers.blogpar.blog.entity.BoardEntity;
import com.ohgiraffers.blogpar.blog.repository.BoardRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


// DTO -> 엔티티
// 엔티티 -> DTO로 변환하는 작업
// 컨트롤러로부터 넘겨받을떄는 DTO로 넘겨받음
// 레포지토리로 넘겨줄땐 엔티티로
// 조회같은 DB에 데이터를 조회할 때는 레포지토리로부터 엔티티로 받아옴
// 컨트롤러로 다시 리턴 할 때는 DTO로 바꿔서 넘겨줌
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    @Autowired
    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }


    // 게시글
    @Transactional
    public void save(BoardDTO boardDTO) {
        // 새로운 BoardEntity 객체를 생성하고 DTO로부터 받은 데이터를 설정
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setBoardTitle(boardDTO.getBoardTitle());
        boardEntity.setBoardContent(boardDTO.getBoardContents());
        // 엔티티에 담은 데이터를 레포지토리로 전달
        boardRepository.save(boardEntity);

    }

    // 게시글 목록 조회

    public List<BoardEntity>  getAllBoards() {
//        List<BoardEntity> boardEntityList = boardRepository.findAll();
//        // 엔티티로 넘겨받은 데이터를 DTO로 바꿔서 컨트롤러에 넘겨줘야됨
//        List<BoardDTO> boardDTOList = new ArrayList<>();
        return boardRepository.findAll();
    }
}
