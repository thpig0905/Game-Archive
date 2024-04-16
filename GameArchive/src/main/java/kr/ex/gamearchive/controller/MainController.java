package kr.ex.gamearchive.controller;

import jakarta.servlet.http.HttpSession;
import kr.ex.gamearchive.domain.BoardDM;
import kr.ex.gamearchive.domain.Boards;
import kr.ex.gamearchive.domain.ChatRoom;
import kr.ex.gamearchive.service.BoardDMService;
import kr.ex.gamearchive.service.BoardsService;
import kr.ex.gamearchive.service.ChatRoomService;
import kr.ex.gamearchive.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MainController {

    private final UserService userService;
    private final BoardsService boardsService;
    private final BoardDMService boardDMService;
    private final ChatRoomService chatRoomService;

    public MainController(UserService userService, BoardsService boardsService, BoardDMService boardDMService, ChatRoomService chatRoomService) {
        this.userService = userService;
        this.boardsService = boardsService;
        this.boardDMService = boardDMService;
        this.chatRoomService = chatRoomService;
    }

    @GetMapping("/main")
    public String main(Model model, HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/";
        }
        List<Boards> boards = boardsService.allBoard();
        List<BoardDM> boardDMs = boardDMService.allBoardDM();
        List<ChatRoom> chatRoom = chatRoomService.allChatRoom();
        model.addAttribute("user", session.getAttribute("user"));
        model.addAttribute("boards", boards);
        model.addAttribute("dms", boardDMs);
        model.addAttribute("chatRooms", chatRoom);
        return "main/main";
    }

    @ResponseBody
    @GetMapping("/board/{boardId}/dms")
    public List<BoardDM> getBoardDMs(@PathVariable Long boardId) {
        return boardDMService.findBoardDMsByBoardId(boardId);
    }
}
