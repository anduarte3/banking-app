package com.eclyn.client.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MainController {
    private final HttpClient httpClient = HttpClient.newHttpClient();

    // Get user balance
    public String getUserBalance(String userId) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("http://localhost:8080/balance/" + userId))
                    .header("Content-Type", "application/json")
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Balance Response code: " + response.statusCode());
            System.out.println("Balance Response body: " + response.body());

            if (response.statusCode() == 200) {
                return response.body();
            }
            return "0.00";

        } catch (Exception err) {
            err.printStackTrace();
            return "0.00";
        }
    }

    // Get transaction history
    public String getTransactions(String userId) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("http://localhost:8080/transactions/" + userId))
                    .header("Content-Type", "application/json")
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Transactions Response code: " + response.statusCode());
            System.out.println("Transactions Response body: " + response.body());

            if (response.statusCode() == 200) {
                return response.body();
            }
            return "No transactions found";

        } catch (Exception err) {
            err.printStackTrace();
            return "Error loading transactions";
        }
    }

    // Deposit money
    public int deposit(String userId, double amount) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String body = "{\"userId\":\"" + userId + "\",\"amount\":" + amount + "}";

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("http://localhost:8080/deposit"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(body))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Deposit Response code: " + response.statusCode());
            System.out.println("Deposit Response body: " + response.body());

            return response.statusCode();

        } catch (Exception err) {
            err.printStackTrace();
            return 500;
        }
    }

    // Withdraw money
    public int withdraw(String userId, double amount) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String body = "{\"userId\":\"" + userId + "\",\"amount\":" + amount + "}";

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("http://localhost:8080/withdraw"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(body))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Withdraw Response code: " + response.statusCode());
            System.out.println("Withdraw Response body: " + response.body());

            return response.statusCode();

        } catch (Exception err) {
            err.printStackTrace();
            return 500;
        }
    }
}