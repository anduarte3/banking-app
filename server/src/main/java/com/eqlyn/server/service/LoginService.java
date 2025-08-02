package com.eqlyn.server.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
    public String loginUser(Integer id) {
        return "User with ID " + id + " logged in.";
    }
}
