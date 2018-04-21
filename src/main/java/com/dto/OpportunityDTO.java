package com.dto;

public class OpportunityDTO {

    private int databaseId;                // A unique identification number in the database.

    /**************************************  Constructors   ***********************************************/
    public OpportunityDTO( ) {
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
