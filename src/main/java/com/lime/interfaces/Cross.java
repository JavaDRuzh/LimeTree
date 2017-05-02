package com.lime.interfaces;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * Created by vdruzhinin on 5/2/2017.
 */
public interface Cross {

    Integer idCross = null;
    String nameTEC = null; // telecommunication equipment cabinets
    String nameCross = null;
    Integer countCrossPorts = null;
    Integer countFreeCrossPorts = null;

    public void calc();
}
