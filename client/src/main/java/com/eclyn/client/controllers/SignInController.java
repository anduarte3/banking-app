package com.eclyn.client.controllers;

import com.eclyn.client.models.SignInRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SignInController {
    private final HttpClient httpClient = HttpClient.newHttpClient();

    public int getSignUpData(SignInRequest signInRequest) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String body = objectMapper.writeValueAsString(signInRequest);

            // Build HTTP request
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("http://localhost:8080/signin"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(body))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Response code: " + response.statusCode());
            System.out.println("Response body: " + response.body());

            return response.statusCode();
        } catch (Exception err) {
            err.printStackTrace();
            return -1;
        }
    }
}
