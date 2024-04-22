package kr.ex.gamearchive.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "board_dm")
@NoArgsConstructor
@ToString
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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