package com.ohgiraffers.blog_st_1.service;


import com.ohgiraffers.blog_st_1.domain.entity.Board;
import com.ohgiraffers.blog_st_1.domain.repository.BoardRepository;
import com.ohgiraffers.blog_st_1.dto.BoardDTO;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {
    private BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Transactional
    public int savePost(BoardDTO boardDTO) {
        return boardRepository.save(boardDTO.toEntity()).getId();
    }

    @Transactional
    public List<BoardDTO> getBoardList() {
        List<Board> boardList = boardRepository.findAll();
        List<BoardDTO> boardDTOList = new ArrayList<>();

        for(Board board : boardList) {
            BoardDTO boardDTO = BoardDTO.builder()
                    .id(board.getId())
                    .blog_author(board.getBlog_author())
                    .blog_title(board.getBlog_title())
                    .blog_content(board.getBlog_content())
                    .createdDate(board.getCreatedDate())
                    .build();
            boardDTOList.add(boardDTO);
        }
        return boardDTOList;
    }
}


