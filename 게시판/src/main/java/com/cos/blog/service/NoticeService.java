package com.cos.blog.service;

import com.cos.blog.dto.ReplySaveRequestDto;
import com.cos.blog.model.Notice;
import com.cos.blog.model.User;
import com.cos.blog.repository.NoticeRepository;
import com.cos.blog.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class NoticeService {
    private final NoticeRepository noticeRepository;
    private final ReplyRepository replyRepository;

    @Transactional
    public void 글쓰기(Notice board, User user) { // title, content
        board.setCount(0);
        board.setUser(user);
        noticeRepository.save(board);
    }

    @Transactional(readOnly = true)
    public Page<Notice> 글목록(Pageable pageable){
        return noticeRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public Notice 글상세보기(int id) {
        return noticeRepository.findById(id)
                .orElseThrow(()->{
                    return new IllegalArgumentException("글 상세보기 실패 : 아이디를 찾을 수 없습니다.");
                });
    }

    @Transactional
    public void 글삭제하기(int id) {
        System.out.println("글삭제하기 : "+id);
        noticeRepository.deleteById(id);
    }

    @Transactional
    public void 글수정하기(int id, Notice requestBoard) {
        Notice board = noticeRepository.findById(id)
                .orElseThrow(()->{
                    return new IllegalArgumentException("글 찾기 실패 : 아이디를 찾을 수 없습니다.");
                }); // 영속화 완료
        board.setTitle(requestBoard.getTitle());
        board.setContent(requestBoard.getContent());
        // 해당 함수로 종료시(Service가 종료될 때) 트랜잭션이 종료됩니다. 이때 더티체킹 - 자동 업데이트가 됨. db flush
    }

    @Transactional
    public void 댓글쓰기(ReplySaveRequestDto replySaveRequestDto) {
        int result = replyRepository.mSave(replySaveRequestDto.getUserId(), replySaveRequestDto.getBoardId(), replySaveRequestDto.getContent());
        System.out.println("BoardService : "+result);
    }

    @Transactional
    public void 댓글삭제(int replyId) {
        replyRepository.deleteById(replyId);
    }
}
