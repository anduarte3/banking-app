package com.eclyn.client.controllers;

import com.eclyn.client.models.SignUpRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SignUpController {
    private final HttpClient httpClient = HttpClient.newHttpClient();

    public void getSignUpData(SignUpRequest signUpRequest) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String body = objectMapper.writeValueAsString(signUpRequest);

            // Build HTTP request
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("http://localhost:8080/signup"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(body))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Response code: " + response.statusCode());
            System.out.println("Response body: " + response.body());

            System.out.println("Good!");
        } catch (Exception err) {
            err.printStackTrace();
        }
    }
}


