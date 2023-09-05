package com.example.oms3;

import com.example.oms3.Database.DatabaseConnection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Login.fxml"));
        Scene scene = new Scene((Parent)fxmlLoader.load(), 650.0, 400.0);
        stage.setTitle("Login");
        stage.setScene(scene);
        scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
        stage.show();
    }

    public static void main(String[] args) throws SQLException {
        Connection connection = DatabaseConnection.getInstance().getConnection();
        launch();
    }
}