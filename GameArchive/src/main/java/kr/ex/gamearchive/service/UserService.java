package kr.ex.gamearchive.service;

import kr.ex.gamearchive.domain.User;
import kr.ex.gamearchive.form.UserForm;
import kr.ex.gamearchive.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    public List<User> allUser() {
        return userRepository.findAll();
    }

    public User findUserByLoginId(String loginId) {
        return userRepository.findUserByLoginId(loginId) != null ? userRepository.findUserByLoginId(loginId) : null;
    }

    @Transactional
    public void updateUser(UserForm form) {
        userRepository.updateUser(form.getId(), form.getLoginId(), form.getPassword(), form.getName(), form.getEmail(), form.getPhone());
    }

    @Transactional
    public void addCoin(Long id, int addCoin) {
        userRepository.addCoin(id, addCoin);
    }
}
