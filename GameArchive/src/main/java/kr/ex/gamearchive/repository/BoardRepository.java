package kr.ex.gamearchive.repository;

import kr.ex.gamearchive.domain.Boards;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardRepository extends JpaRepository<Boards, Long>{

    @Modifying
    @Query("update Boards b set b.likeCount = b.likeCount + 1 where b.id = :id")
    void likeUpdate(Long id);

    List<Boards> findAll(Sort sort);
}
