package com.eqlyn.server.controller;

import com.eqlyn.server.service.LoginService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password) {
        LoginService loginService = new LoginService();
        loginService.loginUser(email, password);
    }
}
