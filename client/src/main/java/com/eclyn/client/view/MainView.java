package com.eclyn.client.view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainView {

    public void display(Stage window) {
        Sidebar sidebarComponent = new Sidebar();
        VBox sidebar = sidebarComponent.getSidebar();

        // Create Main area here
        Label welcomeLabel = new Label("Welcome, User!");


        VBox layoutMain = new VBox(20);
        layoutMain.setPadding(new Insets(50));
        layoutMain.getChildren().addAll(welcomeLabel);

        BorderPane borderPane = new BorderPane();
        borderPane.setLeft(sidebar);
        borderPane.setCenter(layoutMain);

        Scene mainScene = new Scene(borderPane, 1024, 650);
        window.setScene(mainScene);
        window.setTitle("Eclyn Bank");
        window.show();
    }
}
