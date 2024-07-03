package com.sparta.board.service;

import com.sparta.board.common.ApiResponseDto;
import com.sparta.board.common.ResponseUtils;
import com.sparta.board.common.SuccessResponse;
import com.sparta.board.dto.CommentRequestDto;
import com.sparta.board.dto.CommentResponseDto;
import com.sparta.board.entity.Board;
import com.sparta.board.entity.Comment;
import com.sparta.board.entity.User;
import com.sparta.board.entity.enumSet.ErrorType;
import com.sparta.board.entity.enumSet.UserRoleEnum;
import com.sparta.board.exception.RestApiException;
import com.sparta.board.repository.BoardRepository;
import com.sparta.board.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;

    // 댓글 작성
    @Transactional
    public ApiResponseDto<CommentResponseDto> createComment(Long id, CommentRequestDto requestDto, User user) {

        // 선택한 게시글 DB 조회
        Optional<Board> board = boardRepository.findById(id);
        if (board.isEmpty()) {
            throw new RestApiException(ErrorType.NOT_FOUND_WRITING);
        }

        Long parentCommentId = requestDto.getParentCommentId();
        Comment comment = Comment.of(requestDto, board.get(), user);
        if (parentCommentId == null) {  // parentComment 가 없다면
            commentRepository.save(comment);    // 바로 저장
            return ResponseUtils.ok(CommentResponseDto.from(comment));
        }
        // parentComment 가 있다면 parent comment 에 childComment 를 추가
        Comment parentComment = commentRepository.findById(parentCommentId)
                .orElseThrow(() -> new RestApiException(ErrorType.NOT_FOUND_WRITING));
        parentComment.addChildComment(comment); // parentComment 에 childComment 추가
        commentRepository.save(comment);

        return ResponseUtils.ok(CommentResponseDto.from(comment));

    }

    // 댓글 수정
    @Transactional
    public ApiResponseDto<CommentResponseDto> updateComment(Long id, CommentRequestDto requestDto, User user) {

        // 선택한 댓글이 DB에 있는지 확인
        Optional<Comment> comment = commentRepository.findById(id);
        if (comment.isEmpty()) {
            throw new RestApiException(ErrorType.NOT_FOUND_WRITING);
        }

        // 댓글의 작성자와 수정하려는 사용자의 정보가 일치하는지 확인 (수정하려는 사용자가 관리자라면 댓글 수정 가능)
        Optional<Comment> found = commentRepository.findByIdAndUser(id, user);
        if (found.isEmpty() && user.getRole() == UserRoleEnum.USER) {
            throw new RestApiException(ErrorType.NOT_WRITER);
        }

        // 관리자이거나, 댓글의 작성자와 수정하려는 사용자의 정보가 일치한다면, 댓글 수정
        comment.get().update(requestDto, user);
        commentRepository.flush();   // responseDto 에 modifiedAt 업데이트 해주기 위해 saveAndFlush 사용

        // ResponseEntity 에 dto 담아서 리턴
        return ResponseUtils.ok(CommentResponseDto.from(comment.get()));

    }

    // 댓글 삭제
    @Transactional
    public ApiResponseDto<SuccessResponse> deleteComment(Long id, User user) {

        // 선택한 댓글이 DB에 있는지 확인
        Optional<Comment> comment = commentRepository.findById(id);
        if (comment.isEmpty()) {
            throw new RestApiException(ErrorType.NOT_FOUND_WRITING);
        }

        // 댓글의 작성자와 삭제하려는 사용자의 정보가 일치하는지 확인 (삭제하려는 사용자가 관리자라면 댓글 삭제 가능)
        Optional<Comment> found = commentRepository.findByIdAndUser(id, user);
        if (found.isEmpty() && user.getRole() == UserRoleEnum.USER) {
            throw new RestApiException(ErrorType.NOT_WRITER);
        }

        // 관리자이거나, 댓글의 작성자와 삭제하려는 사용자의 정보가 일치한다면, 댓글 삭제
        commentRepository.deleteById(id);

        // ResponseEntity 에 상태코드, 메시지 들어있는 DTO 를 담아서 반환
        return ResponseUtils.ok(SuccessResponse.of(HttpStatus.OK, "댓글 삭제 성공"));

    }

}
