package com.eqlyn.server.controller;

import com.eqlyn.server.service.SignInService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SignInController {
    private SignInService loginService;

    @GetMapping("/login")
    public List<String> login() {
        return List.of("Hello World, Login");
    }
}
