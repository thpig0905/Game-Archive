package kr.ex.gamearchive.controller;

import jakarta.servlet.http.HttpSession;
import kr.ex.gamearchive.domain.User;
import kr.ex.gamearchive.form.UserForm;
import kr.ex.gamearchive.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/join")
    public String join(UserForm form, Model model, HttpSession session) {
        if (form.getName() == null || form.getName().equals("") || form.getLoginId() == null || form.getLoginId().equals("") || form.getPassword() == null || form.getPassword().equals("") || form.getEmail() == null || form.getEmail().equals("") || form.getPhone() == null || form.getPhone().equals("") || form.getGender() == null || form.getGender().equals("")) {
            model.addAttribute("message", "모든 항목을 입력해주세요");
            return "redirect:/";
        }

        List<User> users = userService.allUser();

        for (User user : users) {
            if (user.getLoginId().equals(form.getLoginId())) {
                model.addAttribute("message", "이미 존재하는 아이디입니다");
                return "redirect:/";
            }
        }

        User user = User.builder()
                .loginId(form.getLoginId())
                .password(form.getPassword())
                .name(form.getName())
                .email(form.getEmail())
                .phone(form.getPhone())
                .gender(form.getGender())
                .build();

        userService.join(user);

        user = userService.findUserByLoginId(form.getLoginId());

        session.setAttribute("user", user);

        return "redirect:/main";
    }

    @PostMapping("/login")
    public String login(UserForm form, Model model, HttpSession session) {
        if (form.getLoginId() == null || form.getLoginId().equals("") || form.getPassword() == null || form.getPassword().equals("")) {
            model.addAttribute("message", "아이디와 비밀번호를 입력해주세요");
            return "redirect:/";
        }
        User user;
        try {
            user = userService.findUserByLoginId(form.getLoginId());
        } catch (Exception e) {
            model.addAttribute("message", "존재하지 않는 아이디입니다");
            return "redirect:/";
        }

        if (user == null) {
            model.addAttribute("message", "존재하지 않는 아이디입니다");
            return "redirect:/";
        }

        if (!user.getPassword().equals(form.getPassword())) {
            model.addAttribute("message", "비밀번호가 일치하지 않습니다");
            return "redirect:/";
        }

        session.setAttribute("user", user);

        return "redirect:/main";
    }

    @PostMapping("/update")
    public String update(UserForm form, Model model, HttpSession session) {
        if (form.getName() == null || form.getName().equals("") || form.getPassword() == null || form.getPassword().equals("") || form.getEmail() == null || form.getEmail().equals("") || form.getPhone() == null || form.getPhone().equals("")) {
            model.addAttribute("message", "모든 항목을 입력해주세요");
            return "redirect:/main";
        }

        User user = (User) session.getAttribute("user");

        userService.updateUser(form);

        user = userService.findUserById(user.getId());

        session.setAttribute("user", user);

        return "redirect:/main";
    }

    @PostMapping("/charge")
    public String charge(UserForm form, Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");

        userService.addCoin(form);

        user = userService.findUserById(user.getId());

        session.setAttribute("user", user);

        return "redirect:/main";
    }

    @GetMapping("/remove")
    public String remove(HttpSession session) {
        User user = (User) session.getAttribute("user");

        userService.deleteUser(user.getId());

        session.invalidate();

        return "redirect:/";
    }

}
