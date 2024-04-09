package kr.ex.gamearchive.controller;

import kr.ex.gamearchive.domain.Role;
import kr.ex.gamearchive.domain.User;
import kr.ex.gamearchive.form.UserForm;
import kr.ex.gamearchive.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/join")
    public String join(@ModelAttribute UserForm form, Model model) {
        System.out.println("form = " + form.toString());
        User user = User.builder()
                .loginId(form.getLoginId())
                .password(form.getPassword())
                .name(form.getName())
                .role(Role.USER)
                .email(form.getEmail())
                .phone(form.getPhone())
                .gender(form.getGender())
                .build();
        System.out.println("user = " + user.toString());
        try {
            userService.join(user);
        } catch (IllegalStateException e) {
            model.addAttribute("msg", e.getMessage());
            return "redirect:/home";
        }

        System.out.println("Success");
        model.addAttribute("msg", "회원가입이 완료되었습니다.");

        User loginUser = userService.findUserByLoginId(form.getLoginId());
        model.addAttribute("user", loginUser);
        System.out.println(loginUser.getName());
        return "home/main";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute UserForm form, Model model) {
        User user = userService.findUserByLoginId(form.getLoginId());

        if (user == null) {
            model.addAttribute("msg", "존재하지 않는 아이디입니다.");
            return "redirect:/home/home";
        }

        if (!user.getPassword().equals(form.getPassword())) {
            model.addAttribute("msg", "비밀번호가 일치하지 않습니다.");
            return "redirect:/home/home";
        }

        model.addAttribute("msg", "로그인 성공");
        model.addAttribute("user", user);

        return "home/main";
    }

    @GetMapping("/logout")
    public String logout(User user, Model model) {
        model.addAttribute("msg", "로그아웃 되었습니다.");
        model.addAttribute("user", null);
        return "home/home";
    }

    @GetMapping("/remove")
    public String remove(User user, Model model) {
        userService.remove(user.getId());
        model.addAttribute("msg", "회원탈퇴 되었습니다.");
        model.addAttribute("user", null);
        return "home/home";
    }
}
