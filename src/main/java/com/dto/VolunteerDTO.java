package com.dto;


import java.util.Date;

public class VolunteerDTO {

    private String name = null;
    private String surname = null;
    private Date dateOfBirth = null;
    private boolean male;
    private boolean female;
    private String area = null;
    private String occupation = null;
    private String interests = null;

    private Date appliedLast = null;

    private int databaseID;
    private String username = null;
    private String password = null;
    private String telephone = null;
    private String email = null;
    private Date loggedInLast = null;
    private Date accountCreated = null;

    public VolunteerDTO(){

    }

    public VolunteerDTO(String name, String surname, Date dateOfBirth, boolean male, boolean female,
                        String area, /*String occupation, String interests,*/ Date appliedLast, int databaseID,
                        String username, String password, String telephone, String email, Date loggedInLast,
                        Date accountCreated) {

        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.male = male;
        this.female = female;
        this.area = area;
        this.occupation = occupation;
        this.interests = interests;
        this.appliedLast = appliedLast;
        this.username = username;
        this.password = password;
        this.telephone = telephone;
        this.email = email;
        this.loggedInLast = loggedInLast;
        this.accountCreated = accountCreated;
        this.databaseID = databaseID;
    }

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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
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

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public Date getAppliedLast() {
        return appliedLast;
    }

    public void setAppliedLast(Date appliedLast) {
        this.appliedLast = appliedLast;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getLoggedInLast() {
        return loggedInLast;
    }

    public void setLoggedInLast(Date loggedInLast) {
        this.loggedInLast = loggedInLast;
    }

    public Date getAccountCreated() {
        return accountCreated;
    }

    public void setAccountCreated(Date accountCreated) {
        this.accountCreated = accountCreated;
    }

    public int getDatabaseID() {
        return databaseID;
    }

    public void setDatabaseID(int databaseID) {
        this.databaseID = databaseID;
    }
}
