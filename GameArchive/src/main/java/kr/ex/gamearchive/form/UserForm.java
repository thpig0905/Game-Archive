package kr.ex.gamearchive.form;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserForm {
    private String loginId; // 로그인 아이디
    private String password; // 비밀번호
    private String name; // 이름
    private String email; // 이메일
    private String phone; // 전화번호
    private String gender; // 성별
}
