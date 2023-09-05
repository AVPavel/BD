//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.oms3.Extra;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Tools {
    public Tools() {
    }

    public static void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText((String)null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void showMessage(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText((String)null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
