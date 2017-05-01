package com.lime.db;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * test data base: insert, select, update, delete
 */


public class DataBaseTestZone {

    @Test
    // check insert new zone in data base
    public void test1() {

        ZoneWorker workerZone = new ZoneWorker();

        Zone newZone = new Zone("nameTest", "cityTest", "streetTest");
        workerZone.insertZone(newZone);

        ArrayList<Zone> zones = workerZone.selectZone("name", "nameTest");
        for (int i = 0; i < zones.size(); i++) {
            assertEquals("nameTest", zones.get(i).getNameZone());
            assertEquals("cityTest", zones.get(i).getCityZone());
            assertEquals("streetTest", zones.get(i).getStreetZone());
        }
    }

    @Test
    // check update zone in data baze
    public void test2() {

        ZoneWorker workerZone = new ZoneWorker();

        ArrayList<Zone> zones = workerZone.selectZone("street", "streetTest");
        int idZone = zones.get(0).getIdZone();

        Zone updateZone = new Zone(idZone, "reNameTest", "reCityTest", "reStreetTest");
        workerZone.updateZone(updateZone);

        zones = workerZone.selectZone("city", "reCityTest");

        assertEquals("reNameTest", zones.get(0).getNameZone());
        assertEquals("reCityTest", zones.get(0).getCityZone());
        assertEquals("reStreetTest", zones.get(0).getStreetZone());
    }

    @Test
    //check delete zone in data base
    public void test3() {
        ZoneWorker worker = new ZoneWorker();
        worker.deleteZone("name", "reNameTest");
    }
}
