package kr.ex.gamearchive.repository;

import kr.ex.gamearchive.domain.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<ChatRoom, Long> {
}
