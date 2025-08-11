package com.eclyn.client.view;

import com.eclyn.client.controllers.MainController;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainView {
    Scene mainScene;
    Button logoutBtn;
    Button refreshBtn;

    public void display(Stage window) {
        Sidebar sidebarComponent = new Sidebar();
        VBox sidebar = sidebarComponent.getSidebar();

        MainController mainController = new MainController();

        // Main content
        Label welcomeLabel = new Label("Welcome to your Dashboard");
        welcomeLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        Label balanceLabel = new Label("Account Balance:");
        balanceLabel.setStyle("-fx-font-size: 16px;");

        // This would normally come from sign-in, but for now using placeholder
        String userId = "user123";
        String balance = mainController.getUserBalance(userId);
        Label balanceAmount = new Label("$" + balance);
        balanceAmount.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: green;");

        Label transactionsLabel = new Label("Recent Transactions:");
        transactionsLabel.setStyle("-fx-font-size: 16px;");

        TextArea transactionsArea = new TextArea();
        transactionsArea.setEditable(false);
        transactionsArea.setPrefRowCount(10);
        transactionsArea.setMaxWidth(400);

        String transactions = mainController.getTransactions(userId);
        transactionsArea.setText(transactions);

        refreshBtn = new Button("Refresh Data");
        refreshBtn.setOnAction(e -> {
            String newBalance = mainController.getUserBalance(userId);
            balanceAmount.setText("$" + newBalance);

            String newTransactions = mainController.getTransactions(userId);
            transactionsArea.setText(newTransactions);
        });

        // Layout
        VBox mainContent = new VBox(20);
        mainContent.setPadding(new Insets(50));
        mainContent.getChildren().addAll(
                welcomeLabel,
                balanceLabel,
                balanceAmount,
                transactionsLabel,
                transactionsArea,
                refreshBtn,
                logoutBtn
        );

        BorderPane borderPane = new BorderPane();
        borderPane.setLeft(sidebar);
        borderPane.setCenter(mainContent);

        mainScene = new Scene(borderPane, 1024, 650);
        window.setScene(mainScene);
        window.setTitle("Eclyn Bank - Dashboard");
        window.show();
    }
}