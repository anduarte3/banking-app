package com.eclyn.client.view;

import com.eclyn.client.controllers.SignInController;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SignInView {
    Scene signInScene;
    Button signinBtn;
    Button signupBtn;

    public void display(Stage window) {
        Sidebar sidebarComponent = new Sidebar();
        VBox sidebar = sidebarComponent.getSidebar();

        signupBtn = new Button("Sign up");
        signupBtn.setOnAction(e -> {
            SignUpView signUp = new SignUpView(); // pass stage
            signUp.display(window);
        });

        // Input fields
        Label labelEmail = new Label("Email");
        TextField email = new TextField();
        email.setMaxWidth(140);
        Label labelPassword = new Label("Password");
        PasswordField password = new PasswordField();
        password.setMaxWidth(140);


        SignInController signIn = new SignInController();

        signinBtn = new Button("Sign in");
        signinBtn.setOnAction(e -> {
            signIn.userInput(email.getText(), password.getText());
        });

        // Layout Sign In
        VBox layoutOne = new VBox(20);
        layoutOne.setPadding(new Insets(50));
        layoutOne.getChildren().addAll(labelEmail, email, labelPassword, password, signinBtn, signupBtn);

        BorderPane borderPane = new BorderPane();
        borderPane.setLeft(sidebar);
        borderPane.setCenter(layoutOne);

        // Setting Scene on window
        signInScene = new Scene(borderPane, 1024,650);
        window.setScene(signInScene);
        window.setTitle("Eclyn Bank");
        window.show();

    }
}