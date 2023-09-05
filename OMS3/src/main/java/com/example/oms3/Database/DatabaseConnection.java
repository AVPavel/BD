//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.oms3.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static DatabaseConnection instance;
    private Connection connection;
    private String url = "jdbc:postgresql://localhost:5432/Online shop";
    private String username = "postgres";
    private String password = "Ibanez2022";

    private DatabaseConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection(this.url, this.username, this.password);
        } catch (ClassNotFoundException var2) {
            System.out.println("Database connection create failed " + var2.getMessage());
        }

    }

    public Connection getConnection() {
        return this.connection;
    }

    public static DatabaseConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DatabaseConnection();
        } else if (instance.getConnection().isClosed()) {
            instance = new DatabaseConnection();
        }

        return instance;
    }
}
