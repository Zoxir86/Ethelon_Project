package com.dto;

import org.mindrot.jbcrypt.BCrypt;

import java.util.Date;

public class NgoDTO {

    private String organizationName = null;
    private String webpage = null;
    private String address = null;
    private String streetNo = null;
    private String postalCode = null;
    private String city = null;
    private String country=null;
    private String contactPerson = null;
    private String descGreek = null;
    private String descEnglish = null;
    private String socialMedium1 = null;
    private String socialMedium2 = null;
    private String socialMedium3 = null;
    private String logoId;
    private Date lastOpportunityUpload = null;
    private int userID;
    private int databaseID;
    private String username = null;
    private String password = null;
    private String telephone = null;
    private String email = null;
    private Date loggedInLast = null;
    private Date accountCreated = null;

    public NgoDTO(){

    }

    public NgoDTO(String organizationName, String webpage, String address, String streetNo, String postalCode,
                  String city, String country, String contactPerson, String descGreek, String descEnglish, String socialMedium1,
                  String socialMedium2, String socialMedium3, String logoId, Date lastOpportunityUpload, int databaseID,
                  String username,String password, String telephone, String email, Date loggedInLast, Date accountCreated) {
        this.organizationName = organizationName;
        this.webpage = webpage;
        this.address = address;
        this.streetNo = streetNo;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
        this.contactPerson = contactPerson;
        this.descGreek = descGreek;
        this.descEnglish = descEnglish;
        this.socialMedium1 = socialMedium1;
        this.socialMedium2 = socialMedium2;
        this.socialMedium3 = socialMedium3;
        this.logoId = logoId;
        this.lastOpportunityUpload = lastOpportunityUpload;
        this.username = username;
        this.password = password;
        this.telephone = telephone;
        this.email = email;
        this.loggedInLast = loggedInLast;
        this.accountCreated = accountCreated;
        this.databaseID = databaseID;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getWebpage() {
        return webpage;
    }

    public void setWebpage(String webpage) {
        this.webpage = webpage;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStreetNo() {
        return streetNo;
    }

    public void setStreetNo(String streetNo) {
        this.streetNo = streetNo;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getDescGreek() {
        return descGreek;
    }

    public void setDescGreek(String descGreek) {
        this.descGreek = descGreek;
    }
    public String getDescEnglish() {
        return descEnglish;
    }

    public void setDescEnglish(String descEnglish) {
        this.descEnglish = descEnglish;
    }


    public String getSocialMedium1() {
        return socialMedium1;
    }

    public void setSocialMedium1(String socialMedium1) {
        this.socialMedium1 = socialMedium1;
    }

    public String getSocialMedium2() {
        return socialMedium2;
    }

    public void setSocialMedium2(String socialMedium2) {
        this.socialMedium2 = socialMedium2;
    }

    public String getSocialMedium3() {
        return socialMedium3;
    }

    public void setSocialMedium3(String socialMedium3) {
        this.socialMedium3 = socialMedium3;
    }

    public String getLogoId() {
        return logoId;
    }

    public void setLogoId(String logoId) {
        this.logoId = logoId;
    }

    public Date getLastOpportunityUpload() {
        return lastOpportunityUpload;
    }

    public void setLastOpportunityUpload(Date lastOpportunityUpload) {
        this.lastOpportunityUpload = lastOpportunityUpload;
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
        this.password = BCrypt.hashpw(password, BCrypt.gensalt());
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
