package kr.ex.gamearchive.form;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardForm {
    private String title; // 제목
    private String content; // 내용
    private String image; // 이미지
    private Long writerId; // 작성자
}
