//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.oms3.controller;

import com.example.oms3.Extra.Tools;
import com.example.oms3.Database.DatabaseConnection;
import com.example.oms3.Database.DatabaseManager;
import com.example.oms3.model.Product;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import static com.example.oms3.Extra.Tools.showMessage;

public class AddProductController {
    Connection connection = DatabaseConnection.getInstance().getConnection();
    @FXML
    private Button cancelBtn;
    @FXML
    private Button addBtn;
    @FXML
    private TextField productNameField;
    @FXML
    private TextField categoryIdField;
    @FXML
    private TextField brandIdField;
    @FXML
    private TextField supplierIdField;
    @FXML
    private TextField priceField;
    @FXML
    private TextArea descriptionArea;
    @FXML
    private TextField stockField;

    public AddProductController() throws SQLException {
    }

    public void handleAddProduct(ActionEvent actionEvent) throws SQLException {
        if (!this.productNameField.getText().isEmpty() && !this.categoryIdField.getText().isEmpty() && !this.brandIdField.getText().isEmpty() && !this.supplierIdField.getText().isEmpty() && !this.priceField.getText().isEmpty() && !this.descriptionArea.getText().isEmpty() && !this.stockField.getText().isEmpty()) {
            Product prod = new Product(this.productNameField.getText(), Integer.valueOf(this.categoryIdField.getText()), Integer.valueOf(this.brandIdField.getText()), Integer.valueOf(this.supplierIdField.getText()), Double.valueOf(this.priceField.getText()), this.descriptionArea.getText(), Integer.valueOf(this.stockField.getText()));
            DatabaseManager dbManager = new DatabaseManager(connection);
            try{
                dbManager.addProduct(prod);
                showMessage("Succes","Product Added");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            Tools.showAlert("Error", "Complete / Check every field before submitting");
        }
    }

    public void handleCancel() {
        Stage currentStage = (Stage)this.cancelBtn.getScene().getWindow();
        currentStage.close();

        try {
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com/example/oms3/MainAdmin.fxml"));
            Parent root = (Parent)loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException var5) {
            var5.printStackTrace();
        }

    }
}
