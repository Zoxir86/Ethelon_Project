package com.database;

import javax.persistence.*;

@Entity
@Table(name= "OpportunityCategory")
public class OpportunityCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int categoryID;

    @Column(name = "Description")
    private String description = null;

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}