package com.dto;

public class QuestionDTO {

    private int databaseId;                // A unique identification number in the database.
    private int position;                  // The question's position in the questionnaire.
    private String textEnglish;            // The question's text in English.
    private String textGreek;              // The question's text in Greek.


    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Constructors ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public QuestionDTO ( ) {
        super();
    }

    public QuestionDTO(int databaseId, int position, String textEnglish, String textGreek) {
        this.databaseId = databaseId;
        this.position = position;
        this.textEnglish = textEnglish;
        this.textGreek = textGreek;
    }

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Getters and Setters ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public int getDatabaseId() {
        return databaseId;
    }

    public void setDatabaseId(int databaseId) {
        this.databaseId = databaseId;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getTextEnglish() {
        return textEnglish;
    }

    public void setTextEnglish(String textEnglish) {
        this.textEnglish = textEnglish;
    }

    public String getTextGreek() {
        return textGreek;
    }

    public void setTextGreek(String textGreek) {
        this.textGreek = textGreek;
    }

} // End of QuestionDTO class.