package com.database;

import javax.persistence.*;
import java.util.Date;

@Entity(name="Volunteer")
@DiscriminatorValue("2")
public class Volunteer extends User {

    @Column(name="Name")
    private String name = null;

    @Column(name="Surname")
    private String surname = null;

    @Column(name="DateOfBirth")
    private String dateOfBirth = null;    //TODO Decide on date format.

    @Column(name="Male")
    private boolean male;

    @Column(name="Female")
    private boolean female;

    @Column(name="Area")
    private String area = null;

   // occupations            //TODO

    // interests             //TODO

    @Column(name="AppliedLast")
    //@Temporal(TemporalType.DATE)
    private String appliedLast = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isMale() {
        return male;
    }

    public void setMale(boolean male) {
        this.male = male;
    }

    public boolean isFemale() {
        return female;
    }

    public void setFemale(boolean female) {
        this.female = female;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAppliedLast() {
        return appliedLast;
    }

    public void setAppliedLast(String appliedLast) {
        this.appliedLast = appliedLast;
    }
}



