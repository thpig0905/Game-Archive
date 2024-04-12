package kr.ex.gamearchive.service;

import kr.ex.gamearchive.domain.Boards;
import kr.ex.gamearchive.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardsService {

    private final BoardRepository boardRepository;

    @Transactional
    public void addBoard(Boards board) {
        boardRepository.save(board);
    }

    public Boards findBoardById(Long id) {
        return boardRepository.findById(id).orElse(null);
    }

    @Transactional
    public void likeUpdate(Long id) {
        boardRepository.likeUpdate(id);
    }

    public List<Boards> allBoard() {
        Sort sort = Sort.by(Sort.Direction.DESC, "regDate");
        return boardRepository.findAll(sort);
    }

    @Transactional
    public void deleteBoard(Long id) {
        boardRepository.deleteById(id);
    }
}
