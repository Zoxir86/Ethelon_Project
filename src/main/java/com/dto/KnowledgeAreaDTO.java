package com.dto;

public class KnowledgeAreaDTO {

    private int databaseId;                // A unique identification number in the database.

    /**************************************  Constructors   ***********************************************/
    public KnowledgeAreaDTO( ) {
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
