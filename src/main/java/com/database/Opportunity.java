package com.database;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "opportunity")
@Entity(name="Opportunity")

public class Opportunity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id", updatable = false, nullable = false)       // A unique identification number in the database.
    private int opportunityID;

    @OneToMany( targetEntity=Application.class )                    // A list of applications associated with the opportunity.
    private List<Application> applicationsList;

    /**************************************  Constructors   ***********************************************/
    public Opportunity( ) {
        super();
    }

    /***************************************   Getters and Setters   ***************************************/
    public int getOpportunityID() {
        return opportunityID;
    }

    public void setOpportunityID(int opportunityID) {
        this.opportunityID = opportunityID;
    }

    public List<Application> getApplicationsList() {
        if (applicationsList == null) applicationsList = new ArrayList<Application>();
        return applicationsList;
    }

    public void setApplicationsList(List<Application> applicationsList) {
        this.applicationsList = applicationsList;
    }
}
