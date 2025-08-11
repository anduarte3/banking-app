package com.eclyn.client.controllers;

import com.eclyn.client.models.SignInRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SignInController {
    private static final String SIGNIN_URL = "http://localhost:8080/signin";
    private final HttpClient httpClient = HttpClient.newHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public int getSignUpData(SignInRequest signInRequest) {
        try {
            String body = objectMapper.writeValueAsString(signInRequest);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(SIGNIN_URL))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(body))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Response code: " + response.statusCode());
            System.out.println("Response body: " + response.body());

            return response.statusCode();

        } catch (Exception err) {
            System.err.println("Sign-in failed: " + err.getMessage());
            err.printStackTrace();
            return 500; // Return 500 for server errors instead of -1
        }
    }
}