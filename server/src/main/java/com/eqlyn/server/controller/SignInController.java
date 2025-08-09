package com.eqlyn.server.controller;

import com.eqlyn.server.service.SignInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/signin")
public class SignInController {
    private final SignInService signInService;

    @Autowired
    public SignInController(SignInService signIn) {
        this.signInService = signIn;
    }

    @PostMapping()
    public List<String> getSignIn() {
        return signInService.signin();
    }
}
