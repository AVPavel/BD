//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.oms3.controller;

import com.example.oms3.Database.DatabaseConnection;
import com.example.oms3.Database.DatabaseManager;
import com.example.oms3.HelloApplication;
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
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;

public class MainAdminController {
    Connection connection = DatabaseConnection.getInstance().getConnection();
    @FXML
    private TableView<Product> userTable;
    @FXML
    private TableColumn<Product, String> idColumn;
    @FXML
    private TableColumn<Product, String> nameColumn;
    @FXML
    private TableColumn<Product, String> categoryColumn;
    @FXML
    private TableColumn<Product, String> brandColumn;
    @FXML
    private TableColumn<Product, String> supplierColumn;
    @FXML
    private TableColumn<Product, Double> priceColumn;
    @FXML
    private TableColumn<Product, String> descriptionColumn;
    @FXML
    private TableColumn<Product, Integer> stockColumn;

    public MainAdminController() throws SQLException {
    }

    public void AddProduct() throws IOException {
        FXMLLoader loader = new FXMLLoader(MainAdminController.class.getResource("/com/example/oms3/AddProduct.fxml"));
        Scene scene = new Scene(loader.load(), 650.0, 400.0);
        Stage stage = new Stage();
        stage.setTitle("Add Product");
        stage.setScene(scene);
        scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
        stage.show();
        Stage currentStage = (Stage) this.userTable.getScene().getWindow();
        currentStage.close();
    }

    public void DeleteProduct() throws IOException {
        FXMLLoader loader = new FXMLLoader(MainAdminController.class.getResource("/com/example/oms3/DeleteProduct.fxml"));
        Scene scene = new Scene(loader.load(), 650.0, 400.0);
        Stage stage = new Stage();
        stage.setTitle("Delete Product");
        stage.setScene(scene);
        scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
        stage.show();
        Stage currentStage = (Stage) this.userTable.getScene().getWindow();
        currentStage.close();
    }

    public void ListProducts() throws SQLException {
        populateTable();
    }

    public void ViewOrders() {
        this.userTable.setItems(null);
    }

    public void Exit() throws IOException {
        Stage mainAdminStage = (Stage) this.userTable.getScene().getWindow();
        mainAdminStage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/oms3/Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 650.0, 400.0);
        Stage stage = new Stage();
        stage.setTitle("Login");
        stage.setScene(scene);
        scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
        stage.show();
    }

    public void ClearTable() {
        this.userTable.setItems(null);
    }

    public void initialize() throws SQLException {
        this.idColumn.setCellValueFactory(new PropertyValueFactory("productId"));
        this.nameColumn.setCellValueFactory(new PropertyValueFactory("productName"));
        this.categoryColumn.setCellValueFactory(new PropertyValueFactory("categoryId"));
        this.brandColumn.setCellValueFactory(new PropertyValueFactory("brandID"));
        this.supplierColumn.setCellValueFactory(new PropertyValueFactory("supplierID"));
        this.priceColumn.setCellValueFactory(new PropertyValueFactory("price"));
        this.descriptionColumn.setCellValueFactory(new PropertyValueFactory("description"));
        this.stockColumn.setCellValueFactory(new PropertyValueFactory("stock"));
        this.userTable.setRowFactory((tv) -> {
            TableRow<Product> row = new TableRow();
            row.setOnMouseClicked((event) -> {
                if (event.getClickCount() == 2 && !row.isEmpty()) {
                    Product product = row.getItem();
                    this.openEditWindow(product);
                }
            });
            return row;
        });
        this.populateTable();
    }

    private void openEditWindow(Product product) {
        try {
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com/example/oms3/EditWindow.fxml"));
            Parent root = loader.load();
            EditWindowController controller = loader.getController();
            controller.populateFields(product);
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException var6) {
            var6.printStackTrace();
        }

    }

    public void populateTable() throws SQLException {
        DatabaseManager dbManager = new DatabaseManager(this.connection);
        List<Product> products = dbManager.getAllProducts();
        ObservableList<Product> observableProducts = FXCollections.observableArrayList(products);
        this.userTable.setItems(observableProducts);
    }

    public void populateTableOrders() throws SQLException {
        DatabaseManager dbManager = new DatabaseManager(this.connection);
        List<Product> products = dbManager.getAllProducts();
        ObservableList<Product> observableProducts = FXCollections.observableArrayList(products);
        this.userTable.setItems(observableProducts);
    }
    private void showAlert(String operation) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(operation + " operation triggered.");
        alert.showAndWait();
    }

    public void RefreshTable(ActionEvent actionEvent) throws SQLException {
        this.userTable.setItems(null);
        this.populateTable();
    }
}
