package kr.ex.gamearchive.service;

import kr.ex.gamearchive.domain.Board;
import kr.ex.gamearchive.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    @Transactional
    public Long write(Board board) {
        boardRepository.save(board);
        return board.getBoardId();
    }

    @Transactional
    public void remove(Long boardId) {
        boardRepository.deleteById(boardId);
    }
}
