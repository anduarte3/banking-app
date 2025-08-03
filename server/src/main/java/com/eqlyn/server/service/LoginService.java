package com.eqlyn.server.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

    public String loginUser(String email, String password) {
        // Check database, if user exists and password is correct send to login
        return email;
    }
}
