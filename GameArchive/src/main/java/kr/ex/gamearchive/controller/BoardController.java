package kr.ex.gamearchive.controller;

import jakarta.servlet.http.HttpSession;
import kr.ex.gamearchive.model.BoardDM;
import kr.ex.gamearchive.model.Boards;
import kr.ex.gamearchive.model.User;
import kr.ex.gamearchive.form.BoardDMForm;
import kr.ex.gamearchive.form.BoardForm;
import kr.ex.gamearchive.service.BoardDMService;
import kr.ex.gamearchive.service.BoardsService;
import kr.ex.gamearchive.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {
    private final BoardsService boardsService;
    private final UserService userService;
    private final BoardDMService boardDMService;

    public BoardController(BoardsService boardsService, UserService userService, BoardDMService boardDMService) {
        this.boardsService = boardsService;
        this.userService = userService;
        this.boardDMService = boardDMService;
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

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long boardId) {
        boardsService.deleteBoard(boardId);
        return "redirect:/main";
    }

    @PostMapping("/addDm")
    public String addDm(BoardDMForm form) {
        BoardDM boardDM = BoardDM.builder()
                .userName(form.getUserName())
                .message(form.getMessage())
                .board(boardsService.findBoardById(form.getBoardId()))
                .build();

        boardDMService.addBoardDM(boardDM);

        return "redirect:/main";
    }
}
