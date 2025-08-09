package com.eqlyn.server.service;

import com.eqlyn.server.entity.User;
import com.eqlyn.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SignInService {
    @Autowired
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Autowired
    public SignInService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User findUser(String email, String password) {
        Optional<User> userEmail = userRepository.findByEmail(email);

        if (userEmail.isEmpty()) { return null; }

        User user = userEmail.get();
        System.out.println("Found user: " + user);
        System.out.println("User ID: " + user.getId());

        if (passwordEncoder.matches(password, user.getPassword())) {
            return user;
        }

        return null;
    }
}