package com.eclyn.client.view;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class Sidebar {

    public VBox getSidebar() {
        VBox sidebar = new VBox();
        sidebar.setPadding(new Insets(50));
        sidebar.setSpacing(30);

        Label logo = new Label("Eclyn");
        logo.setStyle("-fx-text-fill: white");
        // You can add more nav items here in future
        sidebar.getChildren().add(logo);
        sidebar.setStyle("-fx-background-color: #05472A");

        return sidebar;
    }
}
