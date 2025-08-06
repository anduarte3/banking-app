package com.eqlyn.server.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SignUpService {

    public List<String> signup() {
        return List.of("Hello World");
    }
}
