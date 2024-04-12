package kr.ex.gamearchive.form;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DonateForm {
    private Long sender;
    private Long receiver;
    private int amount;
    private Long regDate;
}
