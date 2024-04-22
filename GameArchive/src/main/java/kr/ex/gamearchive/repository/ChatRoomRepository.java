package kr.ex.gamearchive.repository;

import kr.ex.gamearchive.model.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {
}
