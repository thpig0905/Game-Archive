package kr.ex.gamearchive.service;

import kr.ex.gamearchive.model.Donate;
import kr.ex.gamearchive.repository.DonateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class DonateService {
    private final DonateRepository donateRepository;

    @Transactional
    public void addDonate(Donate donate) {
        donateRepository.save(donate);
    }
}
