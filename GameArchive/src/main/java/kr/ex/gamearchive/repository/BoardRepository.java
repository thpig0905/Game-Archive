package kr.ex.gamearchive.repository;

import kr.ex.gamearchive.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {

}
