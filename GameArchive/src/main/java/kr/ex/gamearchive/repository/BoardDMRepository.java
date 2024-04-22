package kr.ex.gamearchive.repository;

import kr.ex.gamearchive.model.BoardDM;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardDMRepository extends JpaRepository<BoardDM, Long> {
    List<BoardDM> findBoardDMsByBoardId(Long boardId);
}
