package com.eclyn.client.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class Sidebar {

    public VBox getSidebar() {
        Image bankImage = new Image(
                getClass().getResource("/com/eclyn/client/bank.png").toExternalForm()
        );
        ImageView bankLogo = new ImageView(bankImage);
        bankLogo.setFitHeight(100);
        bankLogo.setFitWidth(100);

        VBox sidebar = new VBox();
        sidebar.setPadding(new Insets(50));
        sidebar.setAlignment(Pos.CENTER); // vertical + horizontal center
        sidebar.setSpacing(30);


        sidebar.setPrefWidth(200); // sidebar width
        sidebar.setStyle("-fx-background-color: #f0f0f0;");

        Label logo = new Label("Eclyn");
        logo.setStyle("-fx-text-fill: white");
        // You can add more nav items here in future
        sidebar.getChildren().add(bankLogo);
        sidebar.setStyle("-fx-background-color: #05472A");

        return sidebar;
    }
}
