package com.lime.database;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

/**
 * Created by druzh on 29.04.17.
 */
public class Main {

    // data for connection
    private static String URL = "jdbc:mysql://localhost:3306/lime_db";
    private static String USERNAME = "root";
    private static final String PASSWORD = "328";

    public static void main(String[] args) {
        Connection connection; // connect to data base

        try {
            Driver driver = new FabricMySQLDriver(); // set use jdbc MySQLDriver
            DriverManager.registerDriver(driver); // registration driver in driver manager
        } catch (SQLException e) {
            e.printStackTrace(); // if library not connect to project
        }

        try{
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement(); // for create a query to db

            // test insert data
            statement.execute("insert into zones (zone_name, zone_city, zone_street) values ('name1', 'city1', 'street1');");
            // test update date
            int res = statement.executeUpdate("update zones set zone_name = 'name1' where zone_name = 'name';");
            System.out.println("update notes: " + res);
            // test select data
            ResultSet resultSet = statement.executeQuery("select * from zones");
            // test insert more then one notes
            statement.addBatch("insert into zones (zone_name, zone_city, zone_street) values ('name2', 'city2', 'street2');");
            statement.addBatch("update zones set zone_name = 'name2' where zone_name = 'name22';");
            statement.addBatch("DELETE FROM zones;");
            statement.executeBatch();
            //statement.clearBatch(); // if need to clear bench and after create new
            //statement.getConnection(); // connection to db
        }  catch (SQLException e) {
            e.printStackTrace(); // if library not conn
            // ect to project
        }

    }
}
