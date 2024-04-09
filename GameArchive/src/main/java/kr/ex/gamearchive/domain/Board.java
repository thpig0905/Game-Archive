package kr.ex.gamearchive.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "board")
@NoArgsConstructor
public class Board {

    @Id
    @Column(name = "board_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId; // 게시글 고유키

    private String title; // 제목
    private String content; // 내용
    private String regDate; // 작성일
    private int hit; // 조회수
    private int like; // 좋아요
    private Long writerId; // 작성자
    private String image; // 이미지

    @Builder
    public Board(Long boardId, String title, String content, String image, Long writerId) {
        this.boardId = boardId;
        this.title = title;
        this.content = content;
        this.image = image;
        this.writerId = writerId;
        this.regDate = new Date().toString();
    }

}
