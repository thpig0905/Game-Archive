package kr.ex.gamearchive.controller;

import jakarta.servlet.http.HttpSession;
import kr.ex.gamearchive.domain.Boards;
import kr.ex.gamearchive.domain.User;
import kr.ex.gamearchive.form.BoardForm;
import kr.ex.gamearchive.service.BoardsService;
import kr.ex.gamearchive.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {
    private final BoardsService boardsService;
    private final UserService userService;

    public BoardController(BoardsService boardsService, UserService userService) {
        this.boardsService = boardsService;
        this.userService = userService;
    }

    @PostMapping("/addBoard")
    public String addBoard(BoardForm form, HttpSession session) {
        User user = (User) session.getAttribute("user");

        Boards board = Boards.builder()
                .title(form.getTitle())
                .content(form.getContent())
                .user(user)
                .build();

        boardsService.addBoard(board);

        List<Boards> boards = boardsService.allBoard();

        session.setAttribute("boards", boards);

        return "redirect:/main";
    }

    @PostMapping("/like")
    public String like(BoardForm form, HttpSession session) {
        Boards board = boardsService.findBoardById(form.getId());

       boardsService.likeUpdate(board.getId());

         List<Boards> boards = boardsService.allBoard();

        return "redirect:/main";
    }
}
