package com.database;

import javax.persistence.*;
import java.util.Date;

@Entity(name="Ngo")
@DiscriminatorValue("3")
public class Ngo extends User {

    @Column(name="Name")
    private String organizationName = null;

    @Column(name="WebPage")
    private String webpage = null;

    @Column(name="Address")
    private String address = null;

    @Column(name="StreetNo")
    private String streetNo = null;

    @Column(name="PostalCode")
    private String postalCode = null;

    @Column(name="City")
    private String city = null;

    @Column(name="Country")
    private String country = null;

    @Column(name="ContactPerson")
    private String contactPerson = null;

    @Column(name="decriptionGreek")
    private String descGreek = null;

    @Column(name="decriptionEnglish")
    private String descEnglish = null;

    @Column(name="SocialMedium1")
    private String socialMedium1 = null;

    @Column(name="SocialMedium2")
    private String socialMedium2 = null;

    @Column(name="SocialMedium3")
    private String socialMedium3 = null;

    @Column(name="logoID")
    private String logoId = null;

    @Column(name="LastOpportunityUpload")
    private String lastOpportunityUpload = null;

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

    public String getLastOpportunityUpload() {
        return lastOpportunityUpload;
    }

    public void setLastOpportunityUpload(String lastOpportunityUpload) {
        this.lastOpportunityUpload = lastOpportunityUpload;
    }
}



