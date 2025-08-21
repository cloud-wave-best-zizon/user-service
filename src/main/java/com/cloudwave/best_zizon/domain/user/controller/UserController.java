package com.cloudwave.best_zizon.domain.user.controller;

import com.cloudwave.best_zizon.domain.user.domain.User;
import com.cloudwave.best_zizon.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<User> signUp(@RequestBody SignUpRequest req) {
        User user = userService.signUp(req.loginId(), req.password());
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody LoginRequest req) {
        User user = userService.login(req.loginId(), req.password());
        return ResponseEntity.ok(user);
    }

    public record SignUpRequest(
            String loginId,
            String password
    ) {}

    public record LoginRequest(
            String loginId,
            String password
    ) {}
}
