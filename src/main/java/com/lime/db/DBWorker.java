package com.lime.db;

import java.sql.*;

/**
 * connection to data base
 */
public class DBWorker {

    // data for connection
    private final String HOST = "jdbc:postgresql://localhost:5432/limedatabase";
    private final String USERNAME = "postgres";
    private final String PASSWORD = "P@ssw0rd";

    private Connection connection;

    public DBWorker() {
        try {
            connection = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // get connection in other class
    public Connection getConnection() {
        return connection;
    }
}



