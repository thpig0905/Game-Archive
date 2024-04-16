package kr.ex.gamearchive.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/game")
public class GameController {
    @GetMapping("/tetris")
    public String tetris() {
        return "game/tetris";
    }
}
