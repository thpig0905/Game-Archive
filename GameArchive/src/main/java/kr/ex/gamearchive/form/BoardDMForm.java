package kr.ex.gamearchive.form;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDMForm {
    private Long id;
    private Long boardId;
    private String userName;
    private String message;
    private Long board;
    private Long user;
}
