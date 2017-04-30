package com.lime.db;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created object Zone and methods for work with him
 */
public class Zone {

    private int idZone;
    private String nameZone;
    private String cityZone;
    private String streetZone;

    // create constructors
    public Zone() {
    }

    public Zone(String nameZone, String cityZone, String streetZone) {
        this.nameZone = nameZone;
        this.cityZone = cityZone;
        this.streetZone = streetZone;
    }

    public Zone(int idZone, String nameZone, String cityZone, String streetZone) {
        this.idZone = idZone;
        this.nameZone = nameZone;
        this.cityZone = cityZone;
        this.streetZone = streetZone;
    }

    // create getters
    public int getIdZone() {
        return idZone;
    }

    public String getNameZone() {
        return nameZone;
    }

    public String getCityZone() {
        return cityZone;
    }

    public String getStreetZone() {
        return streetZone;
    }

    // create setters
    public void setIdZone(int idZone) {
        this.idZone = idZone;
    }

    public void setNameZone(String nameZone) {
        this.nameZone = nameZone;
    }

    public void setCityZone(String cityZone) {
        this.cityZone = cityZone;
    }

    public void setStreetZone(String streetZone) {
        this.streetZone = streetZone;
    }


}
