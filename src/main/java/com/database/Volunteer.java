package com.database;

import javax.persistence.*;
import java.util.List;

@Entity(name="Volunteer")
@DiscriminatorValue("2")

public class Volunteer extends User {

    @Column(name="Name")                                  // A person's first name.
    private String name = null;

    @Column(name="Surname")                               // A person's surname.
    private String surname = null;

    @Column(name="DateOfBirth")                           // A person's birthday.
    private String dateOfBirth = null;

    @Column(name="Sex")                                   // A person's sex. Constants provided by the "Sex" class.
    private String sex;

    @Column(name="isVolunteerYN")                         // Marked positively when the person has previous experience as volunteer.
    private boolean isVolunteerYN;

    @Column(name="isEthelonVolunteerYN")                  // Marked positively when the person has previous experience as volunteer.
    private boolean isEthelonVolunteerYN;

    @Column(name="AppliedLast")                           // Latest date of application.
    private String appliedLast = null;

    @ManyToOne                                            // Accommodation area. Unique areas correspond to postal codes in the database.
    private Area area = null;

    @OneToMany( targetEntity=Application.class )          // Applications history for the person.
    private List<Application> applicationsList;

    @OneToMany( targetEntity=Application.class )          // Pending applications for the person.
    private List<Application> pendingApplicationsList;

    @OneToMany( targetEntity=Interest.class )             // Topics in which the person has expressed interest in.
    private List<Interest> interestsList;

    @OneToMany( targetEntity=KnowledgeArea.class )        // Knowledge area in which the person has expressed proficiency in.
    private List<KnowledgeArea> knowledgeAreasList;

    @Column(name="OtherKnowledge")                         // Knowledge areas as a free string/comment marked as "other".
    private String otherKnowledge;

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Constructors ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public Volunteer( ) {
        super();
    }

    public Volunteer(String name, String surname, String dateOfBirth, String sex, boolean isVolunteerYN, boolean isEthelonVolunteerYN, String appliedLast, Area area, List<Application> applicationsList, List<Application> pendingApplicationsList, List<Interest> interestsList, List<KnowledgeArea> knowledgeAreasList, String otherKnowledge) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.isVolunteerYN = isVolunteerYN;
        this.isEthelonVolunteerYN = isEthelonVolunteerYN;
        this.appliedLast = appliedLast;
        this.area = area;
        this.applicationsList = applicationsList;
        this.pendingApplicationsList = pendingApplicationsList;
        this.interestsList = interestsList;
        this.knowledgeAreasList = knowledgeAreasList;
        this.otherKnowledge = otherKnowledge;
    }

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Getters and Setters ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public boolean isVolunteerYN() {
        return isVolunteerYN;
    }

    public void setVolunteerYN(boolean volunteerYN) {
        isVolunteerYN = volunteerYN;
    }

    public boolean isEthelonVolunteerYN() {
        return isEthelonVolunteerYN;
    }

    public void setEthelonVolunteerYN(boolean ethelonVolunteerYN) {
        isEthelonVolunteerYN = ethelonVolunteerYN;
    }

    public String getAppliedLast() {
        return appliedLast;
    }

    public void setAppliedLast(String appliedLast) {
        this.appliedLast = appliedLast;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public List<Application> getApplicationsList() {
        return applicationsList;
    }

    public void setApplicationsList(List<Application> applicationsList) {
        this.applicationsList = applicationsList;
    }

    public List<Application> getPendingApplicationsList() {
        return pendingApplicationsList;
    }

    public void setPendingApplicationsList(List<Application> pendingApplicationsList) {
        this.pendingApplicationsList = pendingApplicationsList;
    }

    public List<Interest> getInterestsList() {
        return interestsList;
    }

    public void setInterestsList(List<Interest> interestsList) {
        this.interestsList = interestsList;
    }

    public List<KnowledgeArea> getKnowledgeAreasList() {
        return knowledgeAreasList;
    }

    public void setKnowledgeAreasList(List<KnowledgeArea> knowledgeAreasList) {
        this.knowledgeAreasList = knowledgeAreasList;
    }

    public String getOtherKnowledge() {
        return otherKnowledge;
    }

    public void setOtherKnowledge(String otherKnowledge) {
        this.otherKnowledge = otherKnowledge;
    }

}



