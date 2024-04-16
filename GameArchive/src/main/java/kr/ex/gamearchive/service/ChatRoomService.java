package kr.ex.gamearchive.service;

import kr.ex.gamearchive.domain.ChatRoom;
import kr.ex.gamearchive.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ChatRoomService {

    private final ChatRoomRepository chatRepository;

    @Transactional
    public void createChatRoom(ChatRoom chatRoom) {
        chatRepository.save(chatRoom);
    }

    public ChatRoom findChatRoom(Long id) {
        return chatRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("채팅방이 존재하지 않습니다."));
    }

    public List<ChatRoom> allChatRoom() {
        return chatRepository.findAll();
    }
}
