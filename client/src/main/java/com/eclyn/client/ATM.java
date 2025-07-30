package com.eclyn.client;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;

import javax.swing.*;
import java.io.IOException;

public class ATM extends Application implements EventHandler<ActionEvent> {
    Button button;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Eclyn Bank");

        button = new Button();
        button.setText("Sign in");

        button.setOnAction(this);
        // Stage = Window
        StackPane layout = new StackPane();
        layout.getChildren().add(button);

        // Scene = everything inside window, buttons, input etc...
        Scene scene = new Scene(layout, 1024, 768);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void handle(ActionEvent event) {
        // Send data to backend
        if (event.getSource() == button) {
            System.out.println("Test");
        }
    }
}