package kr.ex.gamearchive.controller;

import kr.ex.gamearchive.domain.Board;
import kr.ex.gamearchive.form.BoardForm;
import kr.ex.gamearchive.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping("/write")
    public String write(Model model, BoardForm form) {
        System.out.println("form = " + form.getTitle());
        Board board = null;
        if (form.getImage() != null ) {
             board = Board.builder()
                    .title(form.getTitle())
                    .content(form.getContent())
                    .image(form.getImage())
                    .writerId(form.getWriterId())
                    .build();
        } else {
            board = Board.builder()
                    .title(form.getTitle())
                    .content(form.getContent())
                    .writerId(form.getWriterId())
                    .build();
        }
        System.out.println("board = " + board.getTitle());
        try {
             boardService.write(board);
        } catch (IllegalStateException e) {
            model.addAttribute("msg", e.getMessage());
            return "redirect:/main";
        }

        return "redirect:/main";
    }
}
