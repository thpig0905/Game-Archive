package kr.ex.gamearchive.form;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ChatRoomForm {
    private Long id;
    private String name;
    private Date createdDate;
}
