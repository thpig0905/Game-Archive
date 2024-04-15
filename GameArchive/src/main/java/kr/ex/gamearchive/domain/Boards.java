package kr.ex.gamearchive.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import kr.ex.gamearchive.service.UserService;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "boards")
@NoArgsConstructor
@ToString
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Boards {

    @Id
    @Column(name = "board_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;
    private int likeCount;
    private int sponsorCount;
    private Date regDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Boards(String title, String content, User user) {
        this.title = title;
        this.content = content;
        this.user = user;
        this.likeCount = 0;
        this.sponsorCount = 0;
        // 000:00:00 00:00:00
        this.regDate = new Date();
    }
}
