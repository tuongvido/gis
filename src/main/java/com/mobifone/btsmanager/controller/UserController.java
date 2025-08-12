package com.mobifone.btsmanager.controller;

import com.mobifone.btsmanager.entity.User;
import com.mobifone.btsmanager.repository.UserRepository;
import com.mobifone.btsmanager.security.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/users")
@RequiredArgsConstructor
public class UserController {

    private final AuthService authService;
    private final UserRepository userRepository;

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> body) {
        String token = authService.login(body.get("username"), body.get("password"));
        return Map.of("token", token);
    }

    @PostMapping("/logout")
    public Map<String, String> logout(HttpServletRequest request) {
        String token = request.getHeader("Authorization").substring(7);
        authService.logout(token);
        return Map.of("message", "Logged out");
    }

    @PostMapping("/change-password")
    public Map<String, String> changePassword(Authentication authentication, @RequestBody Map<String, String> body) {
        authService.changePassword(authentication.getName(), body.get("newPassword"));
        return Map.of("message", "Password changed");
    }

    // GET all users
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }
}
