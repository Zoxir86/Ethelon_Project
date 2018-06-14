package com.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NgoDTO {

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ As NGO ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private String organizationName = null;							// The organization's official name.
    private String webpage = null;									// Official webpage for the organization.
    private String address = null;									// The organization's postal address (street).
    private String streetNo = null;									// The organization's postal address (number).
    private String postalCode = null;								// The organization's postal address (postal code).
    private String city = null;										// The organization's postal address (city).
    private String country = null;									// The organization's postal address (country).
    private String contactPerson = null;                        	// A contact person for communication between Ethelon and the NGO.
    private String descGreek = null;								// A brief description for the organization in Greek.
    private String descEnglish = null;								// A brief description for the organization in English.
    private String logoId = null;									// The path towards the stored logo image.
    private String status;											// Ngo must be approved by Ethelon to post opportunities. Receives values from enum class ApplicationState.
    private boolean isHiddenYN;										// Indicates whether the organization's application currently appear on website.
    private Date lastOpportunityUpload = null;					    // The date when the latest opportunity has been uploaded by the organization.
    private List<OpportunityDTO> opportunitiesList;					// A list of Opportunities uploaded by the organization.
    private List<SocialMediumDTO> socialMediaList;					// A list of available social media addresses.

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ As User ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private int databaseID;                                         // A unique database identification number.
    private String username = null;                                 // A unique string identifier for the user. Part of the credentials.
    private String password = null;                                 // A unique string identifier for the user. Part of the credentials.
    private String telephone = null;                                // A user's telephone number.
    private String email = null;                                    // A user's e-mail address.
    private Date loggedInLast = null;                               // Latest date of log-in.
    private Date accountCreated = null;                             // The date on which the user account has been created.
    private Date accountUpdated = null;                             // The date on which the user account has last been updated.


    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Constructors ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public NgoDTO( ) {
        super();
    }

    public NgoDTO(String organizationName, String webpage, String address, String streetNo, String postalCode, String city, String country,
                  String contactPerson, String descGreek, String descEnglish, String logoId, String status, boolean isHiddenYN, Date lastOpportunityUpload,
                  List<OpportunityDTO> opportunitiesList, List<SocialMediumDTO> socialMediaList, int databaseID, String username, String password, String telephone,
                  String email, Date loggedInLast, Date accountCreated, Date accountUpdated) {
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
        this.logoId = logoId;
        this.status = status;
        this.isHiddenYN = isHiddenYN;
        this.lastOpportunityUpload = lastOpportunityUpload;
        this.opportunitiesList = opportunitiesList;
        this.socialMediaList = socialMediaList;
        this.databaseID = databaseID;
        this.username = username;
        this.password = password;
        this.telephone = telephone;
        this.email = email;
        this.loggedInLast = loggedInLast;
        this.accountCreated = accountCreated;
        this.accountUpdated = accountUpdated;
    }


    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Getters and Setters ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

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

    public String getLogoId() {
        return logoId;
    }

    public void setLogoId(String logoId) {
        this.logoId = logoId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isHiddenYN() {
        return isHiddenYN;
    }

    public void setHiddenYN(boolean hiddenYN) {
        isHiddenYN = hiddenYN;
    }

    public Date getLastOpportunityUpload() {
        return lastOpportunityUpload;
    }

    public void setLastOpportunityUpload(Date lastOpportunityUpload) {
        this.lastOpportunityUpload = lastOpportunityUpload;
    }

    public List<OpportunityDTO> getOpportunitiesList() {
        return opportunitiesList;
    }

    public void setOpportunitiesList(List<OpportunityDTO> opportunitiesList) {
        if (opportunitiesList == null) opportunitiesList = new ArrayList<OpportunityDTO>();
        this.opportunitiesList = opportunitiesList;
    }

    public List<SocialMediumDTO> getSocialMediaList() {
        return socialMediaList;
    }

    public void setSocialMediaList(List<SocialMediumDTO> socialMediaList) {
        if (socialMediaList == null) socialMediaList = new ArrayList<SocialMediumDTO>();
        this.socialMediaList = socialMediaList;
    }

    public int getDatabaseID() {
        return databaseID;
    }

    public void setDatabaseID(int databaseID) {
        this.databaseID = databaseID;
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

    public Date getAccountUpdated() {
        return accountUpdated;
    }

    public void setAccountUpdated(Date accountUpdated) {
        this.accountUpdated = accountUpdated;
    }
}
