package com.database;

import javax.persistence.*;

@Table(name = "knowledgeArea")
@Entity(name="KnowledgeArea")

public class KnowledgeArea {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id", updatable = false, nullable = false)               // A unique identification number in the database.
    private int knowledgeAreaID;

    @Column(name="DescriptionGreekUpperCase")                              // A string describing the Interest (greek, upper case).
    private String descriptionGreekUpperCase = null;

    @Column(name="DescriptionEnglishUpperCase")                            // A string describing the Interest (english, upper case).
    private String descriptionEnglishUpperCase = null;

    @Column(name="DescriptionGreekLowerCase")                              // A string describing the Interest (greek, lower case).
    private String descriptionGreekLowerCase = null;

    @Column(name="DescriptionEnglishLowerCase")                            // A string describing the Interest (english, lower case).
    private String descriptionEnglishLowerCase = null;


    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Constructors ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public KnowledgeArea( ) {
        super();
    }

    public KnowledgeArea(String descriptionGreekUpperCase, String descriptionEnglishUpperCase, String descriptionGreekLowerCase, String descriptionEnglishLowerCase) {
        this.descriptionGreekUpperCase = descriptionGreekUpperCase;
        this.descriptionEnglishUpperCase = descriptionEnglishUpperCase;
        this.descriptionGreekLowerCase = descriptionGreekLowerCase;
        this.descriptionEnglishLowerCase = descriptionEnglishLowerCase;
    }

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Getters and Setters ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public int getKnowledgeAreaID() {
        return knowledgeAreaID;
    }

    public void setKnowledgeAreaID(int knowledgeAreaID) {
        this.knowledgeAreaID = knowledgeAreaID;
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
