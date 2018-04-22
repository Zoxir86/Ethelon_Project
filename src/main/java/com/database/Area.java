package com.database;

import javax.persistence.*;

@Table(name = "area")
@Entity(name="Area")

public class Area {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id", updatable = false, nullable = false)       // A unique identification number in the database.
    private int areaID;

    @Column(name="PostalCode")                                      // The postal code of a specific area (unique).
    private String postalCode;

    @Column(name="Area")                                            // The area's description. Mostly a municipality, city suburb, big village or island.
    private String area;

    @Column(name="Prefecture")                                      // The prefecture to which the area belongs to.
    private String prefecture;

    @Column(name="Country")                                          // The country to which the area belongs to.
    private String country;


    /**************************************  Constructors   ***********************************************/
    public Area( ) {
        super();
    }

    public Area(String postalCode, String area, String prefecture, String country) {
        this.postalCode = postalCode;
        this.area = area;
        this.prefecture = prefecture;
        this.country = country;
    }

    /***************************************   Getters and Setters   ***************************************/
    public int getAreaID() {
        return areaID;
    }

    public void setAreaID(int areaID) {
        this.areaID = areaID;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPrefecture() {
        return prefecture;
    }

    public void setPrefecture(String perfecture) {
        this.prefecture = perfecture;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}