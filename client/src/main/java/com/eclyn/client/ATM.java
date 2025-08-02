package com.eclyn.client;

import javafx.application.Application;
import javafx.stage.Stage;

// Import other classes
import com.eclyn.client.view.SignInView;

import java.io.IOException;

public class ATM extends Application {
    Stage window;

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