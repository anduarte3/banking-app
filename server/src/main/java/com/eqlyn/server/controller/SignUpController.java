package com.eqlyn.server.controller;

import com.eqlyn.server.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/signup")
public class SignUpController {
    private final SignUpService signUpService;

    @Autowired
    public SignUpController(SignUpService signUp) {
        this.signUpService = signUp;
    }

    @PostMapping()
    public List<String> getSignUp() {
        return signUpService.signup();
    }
}
