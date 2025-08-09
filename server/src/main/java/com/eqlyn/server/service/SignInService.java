package com.eqlyn.server.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SignInService {

    public List<String> signin() {
        return List.of("Hello World, lOGIN");
    }
}
