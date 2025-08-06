package com.eclyn.client.controllers;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SignInController {
    private HttpClient client = HttpClient.newHttpClient();
    String email;
    String password;

    public boolean userInput(String user, String pass) {
        email = user.trim();
        password = pass.trim();

        if (email.isEmpty()) {
            System.out.println("Email is required.");
            return false;
        } else if (!password.matches("\\d{4}")) { // exactly 4 digits
            System.out.println("PIN must be exactly 4 digits.");
            return false;
        }




        System.out.println("Email: " + email);
        System.out.println("PIN accepted (not showing for security!)");
        return true;
    }
}
