module com.eclyn.client {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens com.eclyn.client to javafx.fxml;
    exports com.eclyn.client;
    //exports com.eclyn.client.controllers;
    //opens com.eclyn.client.controllers to javafx.fxml;
}