package com.dto;

public class InterestDTO {

    private int databaseId;                // A unique identification number in the database.

    /**************************************  Constructors   ***********************************************/
    public InterestDTO( ) {
        super();
    }

    /***************************************   Getters and Setters   ***************************************/
    public int getDatabaseId() {
        return databaseId;
    }

    public void setDatabaseId(int databaseId) {
        this.databaseId = databaseId;
    }
}
