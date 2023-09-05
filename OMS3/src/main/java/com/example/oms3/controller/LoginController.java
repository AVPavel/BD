//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.oms3.controller;

import com.example.oms3.Extra.Tools;
import com.example.oms3.Database.DatabaseConnection;
import com.example.oms3.Database.DatabaseManager;
import com.example.oms3.model.User;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;

import static com.example.oms3.Extra.Tools.showAlert;
//import static com.sun.javafx.scene.control.skin.Utils.getResource;

public class LoginController {
    Connection connection = DatabaseConnection.getInstance().getConnection();
    @FXML
    private TextField usernameField;
    @FXML
    private TextField passwordField;
    @FXML
    private Button loginButton;

    public LoginController() throws SQLException {
    }

    @FXML
    protected void onLoginButtonClick() {
        try {
            if (!this.usernameField.getText().isEmpty() && !this.passwordField.getText().isEmpty()) {
                User loginUser = new User(this.usernameField.getText(), this.passwordField.getText());
                DatabaseManager dbManager = new DatabaseManager(this.connection);
                FXMLLoader fxmlLoader;
                Scene scene;
                Stage stage;
                Stage loginStage;
                if (dbManager.LoginUser(loginUser) && dbManager.openAdmin(loginUser)) {
                    Tools.showMessage("Succes", "Login succesfully, click Okay");
                    fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/oms3/MainAdmin.fxml"));
                    scene = new Scene((Parent)fxmlLoader.load(), 650.0, 400.0);
                    stage = new Stage();
                    stage.setTitle("Admin Dashboard");
                    stage.setScene(scene);
                    scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
                    stage.show();
                    loginStage = (Stage)this.loginButton.getScene().getWindow();
                    loginStage.close();
                } /*else if (dbManager.LoginUser(loginUser) && !dbManager.openAdmin(loginUser)) {
                    Tools.showMessage("Succes", "Login succesfully, click Okay");
                    fxmlLoader = new FXMLLoader(this.getClass().getResource("MainUser.fxml"));
                    scene = new Scene((Parent)fxmlLoader.load(), 650.0, 400.0);
                    stage = new Stage();
                    stage.setTitle("User Dashboard");
                    stage.setScene(scene);
                    scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
                    stage.show();
                    loginStage = (Stage)this.loginButton.getScene().getWindow();
                    loginStage.close();*/
                else {
                    showAlert("Error", "The user does not exist or it is not an admin");
                }

            } else {
                showAlert("Error", "Please complete all the fields");
            }
        } catch (SQLException var7) {
            var7.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    protected void onRegisterButtonClick() {
        try {
            //showAlert("error", String.valueOf(getClass().getResource("/com/example/oms3/Register.fxml")));
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/oms3/Register.fxml"));
            Parent registerRoot = fxmlLoader.load();
            Scene registerScene = new Scene(registerRoot);
            Stage registerStage = new Stage();
            registerStage.setScene(registerScene);
            registerStage.setTitle("Register");
            registerScene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
            registerStage.show();
        } catch (IOException var5) {
            throw new RuntimeException(var5);
        }
    }
}
