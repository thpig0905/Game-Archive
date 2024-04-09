package kr.ex.gamearchive.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user")
@NoArgsConstructor
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 고유키

    private String loginId; // 로그인 아이디
    private String password; // 비밀번호
    private String name; // 이름
    private String email; // 이메일
    private String phone; // 전화번호
    private String gender; // 성별
    private int coin; // 보유 코인
    private String profile; // 프로필 이미지 url
    private String regDate; // 가입일
    private int level; // 레벨
    private int status; // 상태
    private int loginCount; // 로그인 횟수
    private String lastLogin; // 마지막 로그인 일시
    private String title; // 칭호

    @Enumerated(EnumType.STRING)
    private Role role; // 권한

    @Builder
    public User(Long id, String loginId, String password, String name, String email, String phone, String gender, Role role) {
        this.id = id;
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.role = role;
    }
}
