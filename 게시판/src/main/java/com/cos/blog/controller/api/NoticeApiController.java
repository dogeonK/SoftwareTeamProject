package com.cos.blog.controller.api;

import com.cos.blog.config.auth.PrincipalDetail;
import com.cos.blog.dto.ReplySaveRequestDto;
import com.cos.blog.dto.ResponseDto;
import com.cos.blog.model.Notice;
import com.cos.blog.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
public class NoticeApiController {
    @Autowired
    private NoticeService noticeService;

    @PostMapping("/api/notice")
    public ResponseDto<Integer> save(@RequestBody Notice board, @AuthenticationPrincipal PrincipalDetail principal) {
        noticeService.글쓰기(board, principal.getUser());
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    @DeleteMapping("/api/notice/{id}")
    public ResponseDto<Integer> deleteById(@PathVariable int id){
        noticeService.글삭제하기(id);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    @PutMapping("/api/notice/{id}")
    public ResponseDto<Integer> update(@PathVariable int id, @RequestBody Notice board){
        System.out.println("BoardApiController : update : id : "+id);
        System.out.println("BoardApiController : update : board : "+board.getTitle());
        System.out.println("BoardApiController : update : board : "+board.getContent());
        noticeService.글수정하기(id, board);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    // 데이터 받을 때 컨트롤러에서 dto를 만들어서 받는게 좋다.
    // dto 사용하지 않은 이유는!!
    @PostMapping("/api/notice/{boardId}/reply")
    public ResponseDto<Integer> replySave(@RequestBody ReplySaveRequestDto replySaveRequestDto) {
        noticeService.댓글쓰기(replySaveRequestDto);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    @DeleteMapping("/api/notice/{boardId}/reply/{replyId}")
    public ResponseDto<Integer> replyDelete(@PathVariable int replyId) {
        noticeService.댓글삭제(replyId);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }
}
