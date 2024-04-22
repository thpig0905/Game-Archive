package kr.ex.gamearchive.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "chat_rooms")
@NoArgsConstructor
@ToString
public class ChatRoom {
    @Id
    @Column(name = "chat_room_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Date createdDate;

    @Builder
    public ChatRoom(String name) {
        this.name = name;
        this.createdDate = new Date();
    }
}
