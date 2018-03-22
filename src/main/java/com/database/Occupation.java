package com.database;

import javax.persistence.*;

@Entity
@Table(name= "Occupation")
public class Occupation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int occupationId;

    @Column(name = "Description")
    private String description = null;

    public int getOccupationId() {
        return occupationId;
    }

    public void setOccupationId(int occupationId) {
        this.occupationId = occupationId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}