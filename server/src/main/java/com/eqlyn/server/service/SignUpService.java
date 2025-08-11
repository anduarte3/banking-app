package com.eqlyn.server.service;

import com.eqlyn.server.entity.Account;
import com.eqlyn.server.entity.User;
import com.eqlyn.server.repository.AccountRepository;
import com.eqlyn.server.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignUpService {
    @Autowired
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final AccountRepository accountRepository;

    @Autowired
    public SignUpService(UserRepository userRepository, AccountRepository accountRepository ,PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public User createUser(String firstName, String lastName, String email, String password) {
        System.out.println("Service called - creating user: " + firstName + ", " + email);

        Account newAccount = new Account();
        Account savedAccount = accountRepository.save(newAccount);
        System.out.println("Created account with ID: " + savedAccount.getAccountId());

        User newUser = new User();
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        newUser.setEmail(email);
        newUser.setPassword(passwordEncoder.encode(password));
        newUser.setAccountId(savedAccount.getAccountId()); // Link to the account

        System.out.println("About to save user: " + newUser);
        User savedUser = userRepository.save(newUser);
        System.out.println("User saved with ID: " + savedUser.getId());

        return savedUser;
    }
}
