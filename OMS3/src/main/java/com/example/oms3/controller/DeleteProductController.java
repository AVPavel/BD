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
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class DeleteProductController {
    Connection connection = DatabaseConnection.getInstance().getConnection();
    @FXML
    private TextField productIdField;
    @FXML
    private Button deleteProductBtn;
    @FXML
    private Button cancelBtn;
    @FXML
    private TableView<Product> productsTable;
    @FXML
    private TableColumn<Product, Integer> idColumn;
    @FXML
    private TableColumn<Product, String> nameColumn;

    public DeleteProductController() throws SQLException {
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

    public void initialize() throws SQLException {
        this.idColumn.setCellValueFactory(new PropertyValueFactory("productId"));
        this.nameColumn.setCellValueFactory(new PropertyValueFactory("productName"));
        this.populateTable();
    }

    private void populateTable() throws SQLException {
        DatabaseManager dbManager = new DatabaseManager(this.connection);
        List<Product> products = dbManager.getAllProducts();
        ObservableList<Product> observableProducts = FXCollections.observableArrayList(products);
        this.productsTable.setItems(observableProducts);
    }

    public void handleDeleteProduct(ActionEvent actionEvent) throws SQLException {
        if (this.productIdField.getText().isEmpty()) {
            Tools.showMessage("Error", "Product ID cannot be empty");
        } else {
            DatabaseManager dbManager = new DatabaseManager(this.connection);

            try {
                if (dbManager.deleteProduct(Integer.valueOf(this.productIdField.getText()))) {
                    Tools.showMessage("Info", "The product was deleted");
                    this.populateTable();
                }
            } catch (Exception var4) {
                var4.printStackTrace();
            }
        }
    }
}
