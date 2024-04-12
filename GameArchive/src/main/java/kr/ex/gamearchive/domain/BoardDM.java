package kr.ex.gamearchive.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "board_dm")
@NoArgsConstructor
@ToString
public class BoardDM {
    @Id
    @Column(name = "board_dm_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;
    private String message;
    private Date regDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Boards board;

    @Builder
    public BoardDM(String userName, String message, Boards board) {
        this.userName = userName;
        this.message = message;
        this.board = board;
        this.regDate = new Date();
    }
}