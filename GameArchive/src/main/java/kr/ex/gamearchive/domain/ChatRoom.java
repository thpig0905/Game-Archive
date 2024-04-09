package kr.ex.gamearchive.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "chat_room")
@NoArgsConstructor
public class ChatRoom {

    @Id
    @Column(name = "chat_room_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roomName;
    private int status;
    private String regDate;

    @Builder
    public ChatRoom(Long id, String roomName, int status, String regDate) {
        this.id = id;
        this.roomName = roomName;
        this.status = status;
        this.regDate = regDate;
    }
}
