package com.lime.db;

import java.sql.*;
import java.util.ArrayList;

/**
 * Create, update, select, delete zone.
 */
public class ZoneWorker {

    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement preparedStatement;
    private static ResultSet resultSet;

    // number of column in zone table
    private final int ID_ZONE = 4;
    private final int NAME_ZONE = 1;
    private final int CITY_ZONE = 2;
    private final int STREET_ZONE = 3;


    //insert new note zone
    public void insertZone(Zone newZone) {

        final String INSERT_NEW_ZONE = "INSERT INTO zone VALUES (?,?,?)";
        try {
            DBWorker worker = new DBWorker();
            connection = worker.getConnection();
            preparedStatement = connection.prepareStatement(INSERT_NEW_ZONE);
            preparedStatement.setString(NAME_ZONE, newZone.getNameZone());
            preparedStatement.setString(CITY_ZONE, newZone.getCityZone());
            preparedStatement.setString(STREET_ZONE, newZone.getStreetZone());

            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //close connection, preparedStatement
            try {
                connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                preparedStatement.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    // update zone
    public void updateZone(Zone updateZone) {

        int idZone = updateZone.getIdZone();
        String nameZone = updateZone.getNameZone();
        String cityZone = updateZone.getCityZone();
        String streetZone = updateZone.getStreetZone();

        String UPDATE_NAME_ZONE = "UPDATE zone SET name_zone = '" + nameZone + "' WHERE id_zone = " + idZone + ";";
        String UPDATE_CITY_ZONE = "UPDATE zone SET city_zone = '" + cityZone + "' WHERE id_zone = " + idZone + ";";
        String UPDATE_STREET_ZONE = "UPDATE zone SET street_zone = '" + streetZone + "' WHERE id_zone = " + idZone + ";";

        try {
            DBWorker worker = new DBWorker();
            connection = worker.getConnection();
            statement = connection.createStatement();

            statement.addBatch(UPDATE_NAME_ZONE);
            statement.addBatch(UPDATE_CITY_ZONE);
            statement.addBatch(UPDATE_STREET_ZONE);
            statement.executeBatch();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //close connection, statement
            try {
                connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                statement.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    // select all zone
    public ArrayList<Zone> selectZone(String key, String string) {

        ArrayList<Zone> zones = new ArrayList<Zone>();

        String select = "";

        if (key.equals("all")) select = "SELECT * FROM zone;";
        if (key.equals("name")) select = "SELECT * FROM zone WHERE name_zone = '" + string + "';";
        if (key.equals("city")) select = "SELECT * FROM zone WHERE city_zone = '" + string + "';";
        if (key.equals("street")) select = "SELECT * FROM zone WHERE street_zone = '" + string + "';";


        try {
            DBWorker worker = new DBWorker();
            connection = worker.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(select);


            while (resultSet.next()) {
                int i = 0;
                Zone zone = new Zone();
                zone.setIdZone(resultSet.getInt("id_zone"));
                zone.setNameZone(resultSet.getString("name_zone"));
                zone.setCityZone(resultSet.getString("city_zone"));
                zone.setStreetZone(resultSet.getString("street_zone"));
                zones.add(zone);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //close connection, statement
            try {
                connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                statement.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                resultSet.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return zones;
    }


    public void deleteZone(String key, String string) {

        String select = "";

        if (key.equals("all")) select = "DELETE FROM zone;";
        if (key.equals("name")) select = "DELETE FROM zone WHERE name_zone = '" + string + "';";
        if (key.equals("city")) select = "DELETE FROM zone WHERE city_zone = '" + string + "';";
        if (key.equals("street")) select = "DELETE FROM zone WHERE street_zone = '" + string + "';";

        try {
            DBWorker worker = new DBWorker();
            connection = worker.getConnection();
            statement = connection.createStatement();

            statement.addBatch(select);
            statement.executeBatch();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //close connection, statement
            try {
                connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                statement.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
