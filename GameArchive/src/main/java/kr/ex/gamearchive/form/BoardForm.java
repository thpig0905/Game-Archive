package kr.ex.gamearchive.form;

import kr.ex.gamearchive.model.User;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BoardForm {
    private Long id; // 고유키
    private String title; // 제목
    private String content; // 내용
    private User user; // 작성자
    private Date regDate; // 작성일

}
