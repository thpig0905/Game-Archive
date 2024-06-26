package kr.ex.gamearchive.controller;

import jakarta.servlet.http.HttpSession;
import kr.ex.gamearchive.model.Donate;
import kr.ex.gamearchive.model.User;
import kr.ex.gamearchive.form.DonateForm;
import kr.ex.gamearchive.service.DonateService;
import kr.ex.gamearchive.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/donate")
public class DonateController {

    private final UserService userService;
    private final DonateService donateService;

    public DonateController(UserService userService, DonateService donateService) {
        this.userService = userService;
        this.donateService = donateService;
    }

    @PostMapping("/send")
    public String sendDonate(DonateForm form, HttpSession session) {
        User sender = userService.findUserById(form.getSender());

        if (sender.getCoin() < form.getAmount()) {
            return "redirect:/main";
        }

        Donate donate = Donate.builder()
                .sender(form.getSender())
                .receiver(form.getReceiver())
                .amount(form.getAmount())
                .build();

        sender.setCoin(sender.getCoin() - form.getAmount());

        userService.updateCoin(sender);

        User receiver = userService.findUserById(form.getReceiver());

        receiver.setCoin(receiver.getCoin() + form.getAmount());

        userService.updateCoin(receiver);

        session.setAttribute("user", sender);

        donateService.addDonate(donate);

        return "redirect:/main";
    }
}
