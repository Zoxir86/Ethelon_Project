package com.database;

import javax.persistence.*;

@Table(name = "application")
@Entity(name="Application")

public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id", updatable = false, nullable = false)       // A unique identification number in the database.
    private int applicationID;

    @ManyToOne                                                      // The application is addressed to a particular opportunity.
    private Opportunity opportunity;

    @ManyToOne                                                      // The application has been created by a particular volunteer.
    private Volunteer volunteer;

    @Column(name="Status")                                          // The current status of an application. Receives values from enum class ApplicationState.
    private String status;

    @Column(name="InsertDate")                                      // The date on which the application was persisted.
    private String insertDate;

    @Column(name="StatusUpdate")                                    // The date on which the application status was last updated.
    private String statusUpdate;

    @Column(name="CV_Identifier")                                   // The identifier of a Curriculum Vitae document uploaded with the application.
    private String cvIdentifier;

    @Column(name="Availability")                                    // The volunteer's availability (entered through a form as free text).
    private String availability;

    @Column(name="Comments")                                        // General comments (entered through a form as free text).
    private String comments;

    /**************************************  Constructors   ***********************************************/
    public Application( ) {
        super();
    }

    public Application(Opportunity opportunity, Volunteer volunteer, String status, String insertDate, String statusUpdate, String cvIdentifier, String availability, String comments) {
        this.opportunity = opportunity;
        this.volunteer = volunteer;
        this.status = status;
        this.insertDate = insertDate;
        this.statusUpdate = statusUpdate;
        this.cvIdentifier = cvIdentifier;
        this.availability = availability;
        this.comments = comments;
    }

    /***************************************   Getters and Setters   ***************************************/
    public int getApplicationID() {
        return applicationID;
    }

    public void setApplicationID(int applicationID) {
        this.applicationID = applicationID;
    }

    public Opportunity getOpportunity() {
        return opportunity;
    }

    public void setOpportunity(Opportunity opportunity) {
        this.opportunity = opportunity;
    }

    public Volunteer getVolunteer() {
        return volunteer;
    }

    public void setVolunteer(Volunteer volunteer) {
        this.volunteer = volunteer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(String insertDate) {
        this.insertDate = insertDate;
    }

    public String getStatusUpdate() {
        return statusUpdate;
    }

    public void setStatusUpdate(String statusUpdate) {
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
