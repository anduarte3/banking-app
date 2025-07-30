package com.eclyn.client.view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SignInView {
    Scene signInScene;
    Scene signUpScene;
    Button signinBtn;
    Button signupBtn;

    public void display(Stage window) {

        Label labelOne = new Label("Welcome first scene");

        signinBtn = new Button("Sign in");
        signinBtn.setOnAction(e -> System.out.println("Hey now"));

        signupBtn = new Button("Sign up");
        signupBtn.setOnAction(e -> {
            SignUpView signUp = new SignUpView(); // pass stage
            signUp.display(window);
        });

        TextField username = new TextField("username");
        TextField password = new TextField("password");

        // Layout Sign In
        VBox layoutOne = new VBox(20);
        layoutOne.setPadding(new Insets(50));
        layoutOne.getChildren().addAll(labelOne, username, password, signinBtn, signupBtn);

        signInScene = new Scene(layoutOne, 1024,768);
        window.setScene(signInScene);
        window.setTitle("Eclyn Bank");
        window.show();

        System.out.println("Hello from SignInView!");

    }
}