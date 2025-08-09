package com.eqlyn.server.controller;

import com.eqlyn.server.entity.User;
import com.eqlyn.server.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/signup")
public class SignUpController {
    private final SignUpService signUpService;

    @Autowired
    public SignUpController(SignUpService signUpService) {
        this.signUpService = signUpService;
    }

    @PostMapping()
    public User createUser(@RequestBody User user) {
        System.out.println("Controller called with: " + user.getFirstName() + ", " + user.getEmail());
        return signUpService.createUser(
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPassword()
        );
    }
}
