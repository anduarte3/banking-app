package com.eclyn.client;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;

// Import other classes
import com.eclyn.client.view.SignInView;

import javax.swing.*;
import java.io.IOException;

public class ATM extends Application {
    Stage window;
    Scene signInScene;
    Scene signUpScene;
    Button signinBtn;
    Button signupBtn;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        // Stage = Window
        // Scene = everything inside window, buttons, input etc...
        window = stage;

        // Start with Sign in Page
        SignInView signIn = new SignInView(); // pass stage
        signIn.display(window);
    }

}

///src
//└── /com/eclyn/client
//    ├── Main.java                 ← entry point
//    ├── /view
//    │   ├── LoginView.java
//    │   └── DashboardView.java
//    ├── /component
//    │   └── ButtonFactory.java
//    ├── /controller
//    │   └── LoginController.java
//    └── /util
//        └── ValidationUtils.java