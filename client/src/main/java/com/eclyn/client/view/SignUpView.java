package com.eclyn.client.view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SignUpView {
    Scene signUpScene;
    Button signinBtn;

    public void display(Stage window) {
        Label labelTwo = new Label("Welcome second scene");

        TextField FirstName = new TextField("FirstName");
        TextField LastName = new TextField("LastName");
        TextField phoneNumber = new TextField("phoneNumber");
        TextField address = new TextField("address");
        TextField password = new TextField("password");
        TextField confirmPassword = new TextField("confirmPassword");

        signinBtn = new Button("Sign in");
        signinBtn.setOnAction(e -> {
            System.out.println("To go back to login");
            SignInView signIp = new SignInView(); // pass stage
            signIp.display(window);
        });

        // Layout Sign In
        VBox layoutTwo = new VBox(20);
        layoutTwo.setPadding(new Insets(50));
        layoutTwo.getChildren().addAll(labelTwo, FirstName, LastName, phoneNumber, address, password, confirmPassword, signinBtn);

        signUpScene = new Scene(layoutTwo, 1024,768);
        window.setScene(signUpScene);
        window.setTitle("Eclyn Bank");
        window.show();

        System.out.println("Hello from SignInView!");
    }
}
