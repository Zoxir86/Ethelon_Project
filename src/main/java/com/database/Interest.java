package com.database;

import javax.persistence.*;

@Table(name = "interest")
@Entity(name="Interest")

public class Interest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)                  // A unique identification number in the database.
    private int interestId;

    public Interest() {
    }

    public int getInterestId() {
        return interestId;
    }

    public void setInterestId(int interestId) {
        this.interestId = interestId;
    }
}
