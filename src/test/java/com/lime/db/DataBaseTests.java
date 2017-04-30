package com.lime.db;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * test data base: insert, select, update, delete
 */
public class DataBaseTests {

    @Test
    public void testInsertSelectZone() {

        ZoneWorker worker = new ZoneWorker();

        Zone newZone = new Zone("name", "city", "street");
        worker.insertZone(newZone);

        ArrayList<Zone> zones = worker.selectZone();

        assertEquals("name", zones.get(0).getNameZone());
        assertEquals("city", zones.get(0).getCityZone());
        assertEquals("street", zones.get(0).getStreetZone());
    }

    @Test
    public void testUpdateZone() {

        ZoneWorker worker = new ZoneWorker();
        Zone updateZone = new Zone(4, "rename", "recity", "restreet");
        worker.updateZone(updateZone);

        ArrayList<Zone> zones = worker.selectZone();

        assertEquals("rename", zones.get(0).getNameZone());
        assertEquals("recity", zones.get(0).getCityZone());
        assertEquals("restreet", zones.get(0).getStreetZone());
    }

    @Test
    public void testDeliteZone() {
        ZoneWorker worker = new ZoneWorker();
        worker.deleteZone();
        ArrayList<Zone> zones = worker.selectZone();
        assertEquals(null, zones.get(0));
    }
}


//    private static final String INSERT_NEW = "INSERT INTO zone VALUES(?,?,?,?)";
//
//    @Test
//        public void test () {
//
//        try{
//            DBWorker worker = new DBWorker();
//            Connection connection = worker.getConnection();
//            try {
//                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW);
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }


//        DBWorker worker = new DBWorker();
//
//        String qweryInsert = "INSERT INTO zone (name_zone, city_zone, street_zone) VALUES ('name', 'city', 'street');";
//        String qweryUpdate = "UPDATE zone SET name_zone = 'rename' where name_zone = 'name';";
//        String qwerySelect = "SELECT * FROM zone WHERE name_zone = 'name';";
//        String qweryDelete = "DELETE FROM zone WHERE name_zone = 'rename';";
//
//        try {
//            Statement statement = worker.getConnection().createStatement();
//            ResultSet resultSet = statement.executeQuery(qwerySelect);
//
//            while (resultSet.next()){
//                Zone zone = new Zone();
//                zone.setIdZone(resultSet.getInt("id_zone") );
//                zone.setNameZone(resultSet.getString("name_zone"));
//                zone.setCityZone(resultSet.getString("city_zone"));
//                zone.setStreetZone(resultSet.getString("street_zone"));
//            }} catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//
//    }


//        DBWorker worker = new DBWorker();
//
//        String qweryInsert = "INSERT INTO zone (name_zone, city_zone, street_zone) VALUES ('name', 'city', 'street');";
//        String qweryUpdate = "UPDATE zone SET name_zone = 'rename' where name_zone = 'name';";
//        String qwerySelect = "SELECT * FROM zone WHERE name_zone = 'name';";
//        String qweryDelete = "DELETE FROM zone WHERE name_zone = 'rename';";
//
//
//        try {
//            Statement statement = worker.getConnection().createStatement();
//
//            statement.execute(qweryInsert);
//            statement.executeUpdate(qweryUpdate);
//            ResultSet resultSet = statement.executeQuery(qwerySelect);
//
//            assertEquals( "rename",   resultSet.getString("name_zone"));
//            assertEquals( "city",   resultSet.getString("city_zone"));
//            assertEquals( "street",   resultSet.getString("street_zone"));
//
//
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }


//            // test insert data
//            statement.execute("insert into zones (zone_name, zone_city, zone_street) values ('name1', 'city1', 'street1');");
//            // test update date
//            int res = statement.executeUpdate("update zones set zone_name = 'name' where zone_name = 'name1';");
//            System.out.println("update notes: " + res);
//            // test select data
//            ResultSet resultSet = statement.executeQuery("select * from zones");
//            // test insert more then one notes
//            statement.addBatch("insert into zones (zone_name, zone_city, zone_street) values ('name2', 'city2', 'street2');");
//            statement.addBatch("update zones set zone_name = 'name2' where zone_name = 'name22';");
//            statement.addBatch("DELETE FROM zones;");
//            statement.executeBatch();
//            //statement.clearBatch(); // if need to clear bench and after create new
//            //statement.getConnection(); // connection to db
//        }  catch (SQLException e) {
//            e.printStackTrace(); // if library not conn
//            // ect to project
//        }
//
//    }

