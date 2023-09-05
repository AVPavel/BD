//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.oms3.controller;

import com.example.oms3.Extra.Tools;
import com.example.oms3.Database.DatabaseConnection;
import com.example.oms3.Database.DatabaseManager;
import com.example.oms3.model.Product;
import java.sql.Connection;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditWindowController {
    Connection connection = DatabaseConnection.getInstance().getConnection();
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private TextField productIdField;
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

    public EditWindowController() throws SQLException {
    }

    public void handleSaveChanges(ActionEvent actionEvent) throws SQLException {
        if (!this.productNameField.getText().isEmpty() && !this.categoryIdField.getText().isEmpty() && !this.brandIdField.getText().isEmpty() && !this.supplierIdField.getText().isEmpty() && !this.priceField.getText().isEmpty() && !this.descriptionArea.getText().isEmpty() && !this.stockField.getText().isEmpty()) {
            DatabaseManager dbManager = new DatabaseManager(this.connection);
            Product product = new Product(dbManager.getProductIdByName(this.productNameField.getText()), this.productNameField.getText(), Integer.valueOf(this.categoryIdField.getText()), Integer.valueOf(this.brandIdField.getText()), Integer.valueOf(this.supplierIdField.getText()), Double.valueOf(this.priceField.getText()), this.descriptionArea.getText(), Integer.valueOf(this.stockField.getText()));
            if (dbManager.updateProduct(product)) {
                Tools.showMessage("Succes", "The product was updated!");
            }
        } else {
            Tools.showAlert("Error", "Every field must be completed");
        }

    }

    public void handleCancel(ActionEvent actionEvent) {
        Stage editStage = (Stage)this.productNameField.getScene().getWindow();
        editStage.close();
    }

    public void populateFields(Product product) {
        this.productIdField.setText(String.valueOf(product.getProductId()));
        this.productNameField.setText(product.getProductName());
        this.categoryIdField.setText(String.valueOf(product.getCategoryId()));
        this.brandIdField.setText(String.valueOf(product.getBrandID()));
        this.supplierIdField.setText(String.valueOf(product.getSupplierID()));
        this.priceField.setText(String.valueOf(product.getPrice()));
        this.descriptionArea.setText(product.getDescription());
        this.stockField.setText(String.valueOf(product.getStock()));
    }

    public void initialize() {
        this.scrollPane.setFitToWidth(true);
        this.scrollPane.setFitToHeight(true);
    }
}
