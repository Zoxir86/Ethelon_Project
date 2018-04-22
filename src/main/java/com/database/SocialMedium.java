package com.database;

import javax.persistence.*;

@Table(name = "social_medium")
@Entity(name="SocialMedium")

public class SocialMedium {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id", updatable = false, nullable = false)       // A unique identification number in the database.
    private int socialMediumID;

    @Column(name="Name")                                            // The business name of the social medium.
    private String name;

    @Column(name="Website")                                         // The website address for the social medium.
    private String website;

    @Column(name="AccountPrefix")                                   // The prefix address into which the account can be completed.
    private String accountPrefix;

    @Column(name="Icon")                                            // Icon associated to the particular social medium.
    private String icon;

    @Column(name="isActive")                                        // Flag marked positevely if the medium is still considered active.
    private boolean isActiveYN;

    @Column(name="importanceRank")                                  // Importance rank in order to have some always in the beginning of lists, e.g. Facebook vs. MySpace.
    private int importanceRank;

    @Column(name="InsertDate")                                      // The date on which the social medium was first persisted.
    private String insertDate;

    @Column(name="UpdateDate")                                      // The date on which the social medium was last updated.
    private String updateDate;


    /**************************************  Constructors   ***********************************************/
    public SocialMedium( ) {
        super();
    }

    public SocialMedium(String name, String website, String accountPrefix, String icon, boolean isActiveYN, int importanceRank) {
        this.name = name;
        this.website = website;
        this.accountPrefix = accountPrefix;
        this.icon = icon;
        this.isActiveYN = isActiveYN;
        this.importanceRank = importanceRank;
        // Note that insert and update dates are not handled by the constructor.
    }

    /***************************************   Getters and Setters   ***************************************/
    public int getSocialMediumID() {
        return socialMediumID;
    }

    public void setSocialMediumID(int socialMediumID) {
        this.socialMediumID = socialMediumID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getAccountPrefix() {
        return accountPrefix;
    }

    public void setAccountPrefix(String accountPrefix) {
        this.accountPrefix = accountPrefix;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public boolean isActiveYN() {
        return isActiveYN;
    }

    public void setActiveYN(boolean activeYN) {
        isActiveYN = activeYN;
    }

    public int getImportanceRank() {
        return importanceRank;
    }

    public void setImportanceRank(int importanceRank) {
        this.importanceRank = importanceRank;
    }

    public String getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(String insertDate) {
        this.insertDate = insertDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }
} // End of SocialMedium class.
