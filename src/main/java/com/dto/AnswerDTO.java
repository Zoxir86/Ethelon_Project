package com.dto;

import java.util.Date;

public class AnswerDTO {

    private int databaseId;                 // A unique identification number in the database.
    private int position;                   // The answer's position in the answered questionnaire.
    private String answerText;              // The answer's text.
    private Date insertDate;              // The date on which the answer was first persisted.
    private Date updateDate;              // The date on which the answer was last updated.


    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Constructors ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public AnswerDTO()
    {
        super();
    }

    public AnswerDTO(int databaseId, int position, String answerText, Date insertDate, Date updateDate) {
        this.databaseId = databaseId;
        this.position = position;
        this.answerText = answerText;
        this.insertDate = insertDate;
        this.updateDate = updateDate;
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

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

}  // End of AnswerDTO class.
