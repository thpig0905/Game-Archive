package kr.ex.gamearchive.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "user")
@NoArgsConstructor
@ToString
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String loginId;
    private String password;
    private String email;
    private String phone;
    private String gender;
    private Date regDate;
    private String image;
    private String title;
    private int level;
    private int coin;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Builder
    public User(String name, String loginId, String password, String email, String phone, String gender) {
        this.name = name;
        this.loginId = loginId;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.regDate = new Date();
        this.role = Role.USER;
        this.title = "새싹 유저";
        this.level = 1;
        this.coin = 0;
    }

}
