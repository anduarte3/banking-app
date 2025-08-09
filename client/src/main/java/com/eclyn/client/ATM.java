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
    public void start(Stage stage) {
        window = stage;

        SignInView signIn = new SignInView();
        signIn.display(window); // pass stage to display the sign-in UI
    }
}
