package com.eqlyn.server.service;

import com.eqlyn.server.entity.User;
import com.eqlyn.server.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignUpService {
    @Autowired
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Autowired
    public SignUpService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User createUser(String firstName, String lastName, String email, String password) {
        System.out.println("Service called - creating user: " + firstName + ", " + email);

        User newUser = new User();
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        newUser.setEmail(email);
        newUser.setPassword(passwordEncoder.encode(password));
        newUser.setAccountId(generateAccountId());

        System.out.println("About to save user: " + newUser);
        User savedUser = userRepository.save(newUser);
        System.out.println("User saved with ID: " + savedUser.getId());

        return userRepository.save(newUser);
    }

    private Integer generateAccountId() {
        return (int) (System.currentTimeMillis() % 1000000);
    }
}
