package kr.ex.gamearchive.controller;

import jakarta.servlet.http.HttpSession;
import kr.ex.gamearchive.domain.Boards;
import kr.ex.gamearchive.service.BoardsService;
import kr.ex.gamearchive.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {

    private final UserService userService;
    private final BoardsService boardsService;

    public MainController(UserService userService, BoardsService boardsService) {
        this.userService = userService;
        this.boardsService = boardsService;
    }

    @GetMapping("/main")
    public String main(Model model, HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/";
        }
        List<Boards> boards = boardsService.allBoard();
        model.addAttribute("user", session.getAttribute("user"));
        model.addAttribute("boards", boards);
        return "main/main";
    }
}
