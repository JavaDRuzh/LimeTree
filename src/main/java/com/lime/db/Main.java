package com.lime.db;

import java.util.ArrayList;

/**
 * Created by druzh on 30.04.17.
 */
public class Main {
    public static void main(String[] args) {
        Zone newZone = new Zone(4,"name7", "city7", "street7");
        ZoneWorker insert = new ZoneWorker();
        //insert.updateZone(newZone);

        ArrayList<Zone> zones = insert.selectZone();
        System.out.println(zones);

        insert.deleteZone();
    }
}
