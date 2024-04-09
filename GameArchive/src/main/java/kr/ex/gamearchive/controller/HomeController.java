package kr.ex.gamearchive.controller;

import kr.ex.gamearchive.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String home() {
        return "home/home"; // resources/templates/home/home.html
    }

    @RequestMapping("/main")
    public String joinSuccess(Model model) {
        User user = (User) model.getAttribute("user");
        model.addAttribute("user", user);
        return "home/main";
    }

}