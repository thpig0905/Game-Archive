package kr.ex.gamearchive.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "chat")
@NoArgsConstructor
@ToString
public class Chat {

    @Id
    @Column(name = "chat_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;
    private Long userId;
    private Date regDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chat_room_id")
    private ChatRoom chatRoom;

    @Builder
    public Chat(String message, Long userId, ChatRoom chatRoom) {
        this.message = message;
        this.userId = userId;
        this.chatRoom = chatRoom;
        this.regDate = new Date();
    }
}
