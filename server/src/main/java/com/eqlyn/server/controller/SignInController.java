package com.eqlyn.server.controller;

import com.eqlyn.server.entity.User;
import com.eqlyn.server.service.SignInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/signin")
public class SignInController {
    private final SignInService signInService;

    @Autowired
    public SignInController(SignInService signInService) {
        this.signInService = signInService;
    }

    @PostMapping()
    public User createUser(@RequestBody User user) {
        System.out.println("Controller called with: " + user.getEmail());
        return signInService.findUser(
                user.getEmail(),
                user.getPassword()
        );
    }
}