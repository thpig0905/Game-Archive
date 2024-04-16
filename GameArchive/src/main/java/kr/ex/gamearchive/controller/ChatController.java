package kr.ex.gamearchive.controller;

import kr.ex.gamearchive.domain.ChatRoom;
import kr.ex.gamearchive.form.ChatRoomForm;
import kr.ex.gamearchive.service.ChatRoomService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chat")
public class ChatController {

    private final ChatRoomService chatRoomService;

    public ChatController(ChatRoomService chatRoomService) {
        this.chatRoomService = chatRoomService;
    }

    @PostMapping("/createChatRoom")
    public String createChatRoom(ChatRoomForm form) {
        ChatRoom chatRoom = ChatRoom.builder()
                .name(form.getName())
                .build();
        chatRoomService.createChatRoom(chatRoom);

        return "redirect:/main";
    }
}
