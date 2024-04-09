package kr.ex.gamearchive.service;

import kr.ex.gamearchive.domain.User;
import kr.ex.gamearchive.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public Long join(User user) {
        validateUserId(user);
        userRepository.save(user);
        return user.getId();
    }

    private void validateUserId(User user) {
        if (userRepository.findUserByLoginId(user.getLoginId()) != null) {
            throw new IllegalStateException("이미 존재하는 회원아이디입니다");
        }
    }

    public User findUserByLoginId(String loginId) {
        return userRepository.findUserByLoginId(loginId) != null ? userRepository.findUserByLoginId(loginId) : null;
    }

    @Transactional
    public void remove(Long userId) {
        userRepository.deleteById(userId);
    }
}