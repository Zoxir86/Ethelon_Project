package com.dto;

import java.util.Date;

public class ApplicationDTO {

    private int databaseId;                // A unique identification number in the database.
    private Date insertDate;               // The date on which the application was persisted.
    private String status;                 // The current status of an application. Receives values from enum class ApplicationState.
    private Date statusUpdate;             // The date on which the application status was last updated.
    private String cvIdentifier;           // The identifier of a Curriculum Vitae document uploaded with the application.
    private String availability;           // The volunteer's availability (entered through a form as free text).
    private String comments;               // General comments (entered through a form as free text).


    /**************************************  Constructors   ***********************************************/
    public ApplicationDTO( ) {
        super();
    }

    public ApplicationDTO(int databaseId, Date insertDate, String status, Date statusUpdate, String cvIdentifier, String availability, String comments) {
        this.databaseId = databaseId;
        this.insertDate = insertDate;
        this.status = status;
        this.statusUpdate = statusUpdate;
        this.cvIdentifier = cvIdentifier;
        this.availability = availability;
        this.comments = comments;
    }

    /***************************************   Getters and Setters   ***************************************/
    public int getDatabaseId() {
        return databaseId;
    }

    public void setDatabaseId(int databaseId) {
        this.databaseId = databaseId;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStatusUpdate() {
        return statusUpdate;
    }

    public void setStatusUpdate(Date statusUpdate) {
        this.statusUpdate = statusUpdate;
    }

    public String getCvIdentifier() {
        return cvIdentifier;
    }

    public void setCvIdentifier(String cvIdentifier) {
        this.cvIdentifier = cvIdentifier;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
