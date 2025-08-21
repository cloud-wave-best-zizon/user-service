package com.cloudwave.best_zizon.domain.user.service;

import com.cloudwave.best_zizon.domain.user.domain.User;
import com.cloudwave.best_zizon.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public User signUp(String loginId, String password) {
        if (userRepository.existsByLoginId(loginId)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "이미 사용 중인 아이디입니다.");
        }
        User savedUser = userRepository.save(
                User.builder().loginId(loginId).password(password).build()
        );
        return savedUser;
    }

    @Transactional(readOnly = true)
    public User login(String loginId, String password) {
        return userRepository.findByLoginIdAndPassword(loginId, password)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.UNAUTHORIZED, "아이디 또는 비밀번호가 일치하지 않습니다."
                ));
    }
}
