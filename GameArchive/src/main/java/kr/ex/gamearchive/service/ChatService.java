package kr.ex.gamearchive.service;

import kr.ex.gamearchive.domain.ChatRoom;
import kr.ex.gamearchive.repository.ChatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ChatService {

    private final ChatRepository chatRepository;

    public void createChatRoom(ChatRoom chatRoom) {
        chatRepository.save(chatRoom);
    }
}
