package kr.ex.gamearchive.controller;

import jakarta.servlet.http.HttpSession;
import kr.ex.gamearchive.domain.BoardDM;
import kr.ex.gamearchive.domain.Boards;
import kr.ex.gamearchive.service.BoardDMService;
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
    private final BoardDMService boardDMService;

    public MainController(UserService userService, BoardsService boardsService, BoardDMService boardDMService) {
        this.userService = userService;
        this.boardsService = boardsService;
        this.boardDMService = boardDMService;
    }

    @GetMapping("/main")
    public String main(Model model, HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/";
        }
        List<Boards> boards = boardsService.allBoard();
        List<BoardDM> boardDMs = boardDMService.allBoardDM();
        model.addAttribute("user", session.getAttribute("user"));
        model.addAttribute("boards", boards);
        model.addAttribute("dms", boardDMs);
        return "main/main";
    }
}
