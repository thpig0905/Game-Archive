package kr.ex.gamearchive.form;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatForm {
    private String message;
    private Long userId;
    private Long chatRoomId;
}
