package com.eclyn.client.models;

public class SignInRequest {
    private String email;
    private String password;

    public SignInRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }
    
    public String getEmail() { return email; }
    public String getPassword() { return password; }
}
