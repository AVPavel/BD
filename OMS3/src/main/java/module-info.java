module com.example.oms3 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.example.oms3 to javafx.fxml;
    opens com.example.oms3.model to javafx.base;
    opens com.example.oms3.controller to javafx.fxml;
    exports com.example.oms3;
    exports com.example.oms3.controller;
}