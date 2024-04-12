package kr.ex.gamearchive.repository;

import kr.ex.gamearchive.domain.Donate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonateRepository extends JpaRepository<Donate, Long> {

}
