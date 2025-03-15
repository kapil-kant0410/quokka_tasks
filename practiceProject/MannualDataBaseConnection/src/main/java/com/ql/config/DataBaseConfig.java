package com.ql.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConfig {

    private static final String URL = "jdbc:postgresql://localhost:5432/testingDB1";
    private static final String user = "postgres";
    private static final String password = "Ka@12345";

    public static Connection getConnection() {

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(URL, user, password);
            if (connection != null) {
                System.out.println("Connected to PostgreSQL database successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Connection failed to database");
            e.printStackTrace();
        }

        return connection;

    }

}
