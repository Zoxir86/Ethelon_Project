package com.dto;

public class InterestDTO {

    private int databaseID;                                        // A unique identification number in the database.
    private String descriptionGreekUpperCase = null;               // A string describing the Interest (greek, upper case).
    private String descriptionEnglishUpperCase = null;             // A string describing the Interest (english, upper case).
    private String descriptionGreekLowerCase = null;               // A string describing the Interest (greek, lower case).
    private String descriptionEnglishLowerCase = null;             // A string describing the Interest (english, lower case).

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Constructors ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public InterestDTO( ) {
        super();
    }

    public InterestDTO(int databaseID, String descriptionGreekUpperCase, String descriptionEnglishUpperCase, String descriptionGreekLowerCase, String descriptionEnglishLowerCase) {
        this.databaseID = databaseID;
        this.descriptionGreekUpperCase = descriptionGreekUpperCase;
        this.descriptionEnglishUpperCase = descriptionEnglishUpperCase;
        this.descriptionGreekLowerCase = descriptionGreekLowerCase;
        this.descriptionEnglishLowerCase = descriptionEnglishLowerCase;
    }

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Getters and Setters ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public int getDatabaseID() {
        return databaseID;
    }

    public void setDatabaseID(int databaseID) {
        this.databaseID = databaseID;
    }

    public String getDescriptionGreekUpperCase() {
        return descriptionGreekUpperCase;
    }

    public void setDescriptionGreekUpperCase(String descriptionGreekUpperCase) {
        this.descriptionGreekUpperCase = descriptionGreekUpperCase;
    }

    public String getDescriptionEnglishUpperCase() {
        return descriptionEnglishUpperCase;
    }

    public void setDescriptionEnglishUpperCase(String descriptionEnglishUpperCase) {
        this.descriptionEnglishUpperCase = descriptionEnglishUpperCase;
    }

    public String getDescriptionGreekLowerCase() {
        return descriptionGreekLowerCase;
    }

    public void setDescriptionGreekLowerCase(String descriptionGreekLowerCase) {
        this.descriptionGreekLowerCase = descriptionGreekLowerCase;
    }

    public String getDescriptionEnglishLowerCase() {
        return descriptionEnglishLowerCase;
    }

    public void setDescriptionEnglishLowerCase(String descriptionEnglishLowerCase) {
        this.descriptionEnglishLowerCase = descriptionEnglishLowerCase;
    }
}
