package com.dto;

public class AreaDTO {

    private int databaseID;                     // A unique identification number in the database.
    private String postalCode;                  // The postal code of a specific area (unique).
    private String area;                        // The area's description. Mostly a municipality, city suburb, big village or island.
    private String prefecture;                  // The prefecture to which the area belongs to.
    private String country;                     // The country to which the area belongs to.


    /**************************************  Constructors   ***********************************************/
    public AreaDTO( ) {
        super();
    }

    public AreaDTO(int databaseID, String postalCode, String area, String prefecture, String country) {
        this.databaseID = databaseID;
        this.postalCode = postalCode;
        this.area = area;
        this.prefecture = prefecture;
        this.country = country;
    }

    /***************************************   Getters and Setters   ***************************************/
    public int getDatabaseID() {
        return databaseID;
    }

    public void setDatabaseID(int areaID) {
        this.databaseID = areaID;
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

    public void setPrefecture(String prefecture) {
        this.prefecture = prefecture;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
