package kr.ex.gamearchive.repository;

import kr.ex.gamearchive.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findUserByLoginId(String loginId);
    public void deleteById(Long id);
}
