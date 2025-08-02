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

public class SignUpView {
    Scene signUpScene;
    Button signinBtn;
    Button signupBtn;

    public void display(Stage window) {
        Sidebar sidebarComponent = new Sidebar();
        VBox sidebar = sidebarComponent.getSidebar();

        // Input fields
        Label labelFirstName = new Label("First Name");
        TextField FirstName = new TextField();
        FirstName.setMaxWidth(140);
        Label labelLastName = new Label("Last Name");
        TextField LastName = new TextField();
        LastName.setMaxWidth(140);
        Label labelEmail = new Label("Email Name");
        TextField email = new TextField();
        email.setMaxWidth(140);
        Label labelPassword = new Label("Password");
        PasswordField password = new PasswordField();
        password.setMaxWidth(140);
        Label labelConfirmPassword = new Label("Confirm Password");
        PasswordField confirmPassword = new PasswordField();
        confirmPassword.setMaxWidth(140);

        signupBtn = new Button("Sign up");
        signupBtn.setOnAction(e -> {
        });

        signinBtn = new Button("Sign in");
        signinBtn.setOnAction(e -> {
            System.out.println("To go back to login");
            SignInView signIp = new SignInView(); // pass stage
            signIp.display(window);
        });

        // Layout Sign In
        VBox layoutTwo = new VBox(20);
        layoutTwo.setPadding(new Insets(50));
        layoutTwo.getChildren().addAll(labelFirstName, FirstName, labelLastName, LastName,
                labelEmail, email, labelPassword, password, labelConfirmPassword, confirmPassword, signupBtn, signinBtn);

        BorderPane borderPane = new BorderPane();
        borderPane.setLeft(sidebar);
        borderPane.setCenter(layoutTwo);

        signUpScene = new Scene(borderPane, 1024,650);
        window.setScene(signUpScene);
        window.setTitle("Eclyn Bank");
        window.show();
    }
}
