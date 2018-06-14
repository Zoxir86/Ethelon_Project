package com.database;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity(name="Ngo")
@DiscriminatorValue("3")

public class Ngo extends User {

    @Column(name="OrganizationName")                                       // The organization's official name.
    private String organizationName = null;

    @Column(name="WebPage")                                                // Official webpage for the organization.
    private String webpage = null;

    @Column(name="Address")                                                // The organization's postal address (street).
    private String address = null;

    @Column(name="StreetNo")                                               // The organization's postal address (number).
    private String streetNo = null;

    @Column(name="PostalCode")                                             // The organization's postal address (postal code).
    private String postalCode = null;

    @Column(name="City")                                                   // The organization's postal address (city).
    private String city = null;

    @Column(name="Country")                                                // The organization's postal address (country).
    private String country = null;

    @Column(name="ContactPerson")                                          // A contact person for communication between Ethelon and the NGO.
    private String contactPerson = null;                                   // Telephone and e-mail provided by the super class.

    @Column(name="DecriptionGreek")                                        // A brief description for the organization in Greek.
    private String descGreek = null;

    @Column(name="DecriptionEnglish")                                      // A brief description for the organization in English.
    private String descEnglish = null;

    @Column(name="LogoID")                                                 // The path towards the stored logo image.
    private String logoId = null;

    @Column(name="Status")                                                 // Ngo must be approved by Ethelon to post opportunities. Receives values from enum class ApplicationState.
    private String status;

    @Column(name="Hidden")                                                 // Indicates whether the organization's application currently appear on website.
    private boolean isHiddenYN;

    @Column(name="LastOpportunityUpload")                                  // The date when the latest opportunity has been uploaded by the organization.
    private String lastOpportunityUpload = null;

    @OneToMany( targetEntity=Opportunity.class )                           // A list of Opportunities uploaded by the organization.
    private List<Opportunity> opportunitiesList;

    @OneToMany( targetEntity=SocialMedium.class )                          // A list of available social media addresses.
    private List<SocialMedium> socialMediaList;


    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Constructors ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public Ngo( ) {
        super();
    }

    public Ngo(String username, String password, String telephone, String email, String loggedInLast, String accountCreated, String accountUpdated, String organizationName, String webpage, String address, String streetNo, String postalCode, String city, String country, String contactPerson, String descGreek, String descEnglish, String logoId, String status, boolean isHiddenYN, String lastOpportunityUpload, List<Opportunity> opportunitiesList, List<SocialMedium> socialMediaList) {
        super(username, password, telephone, email, loggedInLast, accountCreated, accountUpdated);
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

    public String getLastOpportunityUpload() {
        return lastOpportunityUpload;
    }

    public void setLastOpportunityUpload(String lastOpportunityUpload) {
        this.lastOpportunityUpload = lastOpportunityUpload;
    }

    public List<Opportunity> getOpportunitiesList() {
        if (opportunitiesList == null) opportunitiesList = new ArrayList<Opportunity>();
        return opportunitiesList;
    }

    public void setOpportunitiesList(List<Opportunity> opportunitiesList) {
        this.opportunitiesList = opportunitiesList;
    }

    public List<SocialMedium> getSocialMediaList() {
        if (socialMediaList == null) socialMediaList = new ArrayList<SocialMedium>();
        return socialMediaList;
    }

    public void setSocialMediaList(List<SocialMedium> socialMediaList) {
        this.socialMediaList = socialMediaList;
    }
}



