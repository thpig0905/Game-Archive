package kr.ex.gamearchive.controller;

import kr.ex.gamearchive.domain.User;
import kr.ex.gamearchive.form.UserForm;
import kr.ex.gamearchive.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/main")
public class MainController {

    private final UserService userService;

    public MainController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/join")
    public String join(Model model, UserForm form) {

        User user = User.builder()
                .loginId(form.getLoginId())
                .password(form.getPassword())
                .name(form.getName())
                .phone(form.getPhone())
                .email(form.getEmail())
                .gender(form.getGender())
                .build();

        List<User> users = userService.allUser();

        for (User u : users) {
            if (u.getLoginId().equals(user.getLoginId())) {
                model.addAttribute("user", user);
                return "redirect:/home";
            }
        }

        try {
            userService.join(user);
        } catch (IllegalStateException e) {
            model.addAttribute("msg", e.getMessage());
            model.addAttribute("user", user);
            return "redirect:/home";
        }

        User loginUser = userService.findUserByLoginId(user.getLoginId());

        model.addAttribute("user", loginUser);

        System.out.println("user = " + user.getLoginId());

        return "main/main";
    }

    @PostMapping("/login")
    public String login(Model model, UserForm form) {
        User user = (User) userService.findUserByLoginId(form.getLoginId());
        if (user == null) {
            model.addAttribute("msg", "존재하지 않는 회원입니다");
            return "redirect:/home";
        }
        if (!user.getPassword().equals(form.getPassword())) {
            model.addAttribute("msg", "비밀번호가 일치하지 않습니다");
            return "redirect:/home";
        }
        model.addAttribute("user", user);
        return "main/main";
    }

    @PostMapping("/update")
    public String update(Model model, UserForm form) {
        userService.updateUser(form);
        model.addAttribute("user", userService.findUserByLoginId(form.getLoginId()));
        return "main/main";
    }

    @PostMapping("/charge")
    public String charge(Model model, UserForm form) {
        int addCoin = form.getCoin();

        System.out.println("addCoin = " + addCoin);

        userService.addCoin(form.getId(), addCoin);

        model.addAttribute("user", userService.findUserByLoginId(form.getLoginId()));

        return "main/main";
    }
}
