//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.oms3.controller;

import com.example.oms3.Extra.Tools;
import com.example.oms3.Database.DatabaseConnection;
import com.example.oms3.Database.DatabaseManager;
import com.example.oms3.model.User;
import java.sql.Connection;
import java.sql.SQLException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegisterController {
    Connection connection = DatabaseConnection.getInstance().getConnection();
    @FXML
    private TextField usernameField;
    @FXML
    private TextField passwordField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField phoneField;
    @FXML
    private Button registerButton;

    public RegisterController() throws SQLException {
    }

    @FXML
    protected void onRegisterButtonClick() throws SQLException {
        if (this.usernameField.getText().isEmpty() || this.passwordField.getText().isEmpty() || this.emailField.getText().isEmpty() || this.firstNameField.getText().isEmpty() || this.lastNameField.getText().isEmpty() || this.addressField.getText().isEmpty() || this.phoneField.getText().isEmpty()) {
            Tools.showAlert("Error", "Please complete all fields");
        }

        User registeringUser = new User(this.usernameField.getText(), this.passwordField.getText(), this.emailField.getText(), this.firstNameField.getText(), this.lastNameField.getText(), this.addressField.getText(), this.phoneField.getText());
        DatabaseManager dbManager = new DatabaseManager(this.connection);
        if (dbManager.addUser(registeringUser)) {
            Tools.showMessage("Registered", "The user was succesfully registered");
        } else {
            Tools.showAlert("Error", "Failed to register the user");
        }

        Stage stage = (Stage)this.registerButton.getScene().getWindow();
        stage.close();
    }
}
