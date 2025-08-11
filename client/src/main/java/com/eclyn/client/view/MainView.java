package com.eclyn.client.view;

import com.eclyn.client.controllers.MainController;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainView {
    Scene mainScene;
    Button logoutBtn;
    Button refreshBtn;
    Button depositBtn;
    Button withdrawBtn;
    Label balanceAmount;
    TextArea transactionsArea;
    double currentBalance = 1250.00; // Track balance for calculations

    public void display(Stage window) {
        Sidebar sidebarComponent = new Sidebar();
        VBox sidebar = sidebarComponent.getSidebar();

        MainController mainController = new MainController();

        // Main content
        Label welcomeLabel = new Label("Welcome to your Dashboard");
        welcomeLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        Label balanceLabel = new Label("Account Balance:");
        balanceLabel.setStyle("-fx-font-size: 16px;");

        // For now, use static balance since API returns 403
        balanceAmount = new Label("$" + String.format("%.2f", currentBalance));
        balanceAmount.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: green;");

        // Deposit and Withdraw buttons
        depositBtn = new Button("Deposit Money");
        depositBtn.setStyle("-fx-background-color: #27ae60; -fx-text-fill: white; -fx-font-size: 14px;");
        depositBtn.setOnAction(e -> showDepositDialog());

        withdrawBtn = new Button("Withdraw Money");
        withdrawBtn.setStyle("-fx-background-color: #e74c3c; -fx-text-fill: white; -fx-font-size: 14px;");
        withdrawBtn.setOnAction(e -> showWithdrawDialog());

        HBox transactionButtons = new HBox(15);
        transactionButtons.getChildren().addAll(depositBtn, withdrawBtn);

        Label transactionsLabel = new Label("Recent Transactions:");
        transactionsLabel.setStyle("-fx-font-size: 16px;");

        transactionsArea = new TextArea();
        transactionsArea.setEditable(false);
        transactionsArea.setPrefRowCount(10);
        transactionsArea.setMaxWidth(400);

        // Static transactions since API returns 403
        transactionsArea.setText("+ $500.00 - Salary deposit\n- $25.00 - Coffee shop\n- $120.00 - Grocery store\n+ $100.00 - Transfer from savings");

        refreshBtn = new Button("Refresh Data");
        refreshBtn.setOnAction(e -> {
            // For now, just show a message since API returns 403
            System.out.println("Refresh clicked - API currently returns 403");

            // When your backend is fixed, uncomment these:
            // String newBalance = mainController.getUserBalance("user123");
            // balanceAmount.setText("$" + newBalance);
            // String newTransactions = mainController.getTransactions("user123");
            // transactionsArea.setText(newTransactions);
        });

        // CREATE the logout button (this was missing!)
        logoutBtn = new Button("Logout");
        logoutBtn.setOnAction(e -> {
            System.out.println("Logging out...");
            SignInView signInView = new SignInView();
            signInView.display(window);
        });

        // Layout
        VBox mainContent = new VBox(20);
        mainContent.setPadding(new Insets(50));
        mainContent.getChildren().addAll(
                welcomeLabel,
                balanceLabel,
                balanceAmount,
                transactionButtons,
                transactionsLabel,
                transactionsArea,
                refreshBtn,
                logoutBtn  // Now this won't be null!
        );

        BorderPane borderPane = new BorderPane();
        borderPane.setLeft(sidebar);
        borderPane.setCenter(mainContent);

        mainScene = new Scene(borderPane, 1024, 650);
        window.setScene(mainScene);
        window.setTitle("Eclyn Bank - Dashboard");
        window.show();
    }

    private void showDepositDialog() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Deposit Money");
        dialog.setHeaderText("Enter deposit amount:");
        dialog.setContentText("Amount: $");

        dialog.showAndWait().ifPresent(amount -> {
            try {
                double depositAmount = Double.parseDouble(amount);
                if (depositAmount > 0) {
                    currentBalance += depositAmount;
                    balanceAmount.setText("$" + String.format("%.2f", currentBalance));

                    // Add to transaction history
                    String currentText = transactionsArea.getText();
                    String newTransaction = "+ $" + String.format("%.2f", depositAmount) + " - Deposit\n";
                    transactionsArea.setText(newTransaction + currentText);

                    showAlert("Success", "Deposited $" + String.format("%.2f", depositAmount) + " successfully!");
                } else {
                    showAlert("Error", "Amount must be greater than 0");
                }
            } catch (NumberFormatException e) {
                showAlert("Error", "Please enter a valid amount");
            }
        });
    }

    private void showWithdrawDialog() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Withdraw Money");
        dialog.setHeaderText("Enter withdrawal amount:");
        dialog.setContentText("Amount: $");

        dialog.showAndWait().ifPresent(amount -> {
            try {
                double withdrawAmount = Double.parseDouble(amount);
                if (withdrawAmount > 0) {
                    if (withdrawAmount <= currentBalance) {
                        currentBalance -= withdrawAmount;
                        balanceAmount.setText("$" + String.format("%.2f", currentBalance));

                        // Add to transaction history
                        String currentText = transactionsArea.getText();
                        String newTransaction = "- $" + String.format("%.2f", withdrawAmount) + " - Withdrawal\n";
                        transactionsArea.setText(newTransaction + currentText);

                        showAlert("Success", "Withdrew $" + String.format("%.2f", withdrawAmount) + " successfully!");
                    } else {
                        showAlert("Error", "Insufficient funds. Current balance: $" + String.format("%.2f", currentBalance));
                    }
                } else {
                    showAlert("Error", "Amount must be greater than 0");
                }
            } catch (NumberFormatException e) {
                showAlert("Error", "Please enter a valid amount");
            }
        });
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}