package com.eclyn.client.view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SignUpView {
    Scene signUpScene;
    Button signinBtn;

    public void display(Stage window) {
        Sidebar sidebarComponent = new Sidebar();
        VBox sidebar = sidebarComponent.getSidebar();
        Label labelTwo = new Label("Welcome second scene");

        // Input fields
        Label labelFirstName = new Label("First Name");
        TextField FirstName = new TextField("");
        Label labelLastName = new Label("Last Name");
        TextField LastName = new TextField("");
        Label labelEmail = new Label("Email Name");
        TextField email = new TextField("");
        Label labelPassword = new Label("Password");
        TextField password = new TextField("");
        Label labelConfirmPassword = new Label("Confirm Password");
        TextField confirmPassword = new TextField("");

        signinBtn = new Button("Sign in");
        signinBtn.setOnAction(e -> {
            System.out.println("To go back to login");
            SignInView signIp = new SignInView(); // pass stage
            signIp.display(window);
        });

        // Layout Sign In
        VBox layoutTwo = new VBox(20);
        layoutTwo.setPadding(new Insets(50));
        layoutTwo.getChildren().addAll(labelTwo, labelFirstName, FirstName, labelLastName, LastName,
                labelEmail, email, labelPassword, password, labelConfirmPassword, confirmPassword, signinBtn);

        BorderPane borderPane = new BorderPane();
        borderPane.setLeft(sidebar);
        borderPane.setCenter(layoutTwo);

        signUpScene = new Scene(borderPane, 1024,650);
        window.setScene(signUpScene);
        window.setTitle("Eclyn Bank");
        window.show();
    }
}
