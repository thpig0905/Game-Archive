package kr.ex.gamearchive.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String home(Model model) {
        if (model.getAttribute("user") != null) {
            return "main/main";
        }
        return "home/home";
    }

    @RequestMapping("/logout")
    public String logout(Model model) {

        return "home/home";
    }
}
