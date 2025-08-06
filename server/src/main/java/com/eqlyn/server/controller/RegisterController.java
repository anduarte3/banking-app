package com.eqlyn.server.controller;

import com.eqlyn.server.service.LoginService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {

    @PostMapping("/register")
    public String register(@RequestParam) {

    }
}
