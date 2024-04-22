package kr.ex.gamearchive.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "donate")
@NoArgsConstructor
@ToString
public class Donate {
    @Id
    @Column(name = "donate_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int amount;
    private Long sender;
    private Long receiver;
    private Date regDate;

    @Builder
    public Donate(int amount, Long sender, Long receiver) {
        this.amount = amount;
        this.sender = sender;
        this.receiver = receiver;
        this.regDate = new Date();
    }
}
