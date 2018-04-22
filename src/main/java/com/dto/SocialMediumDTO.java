package com.dto;

import java.util.Date;

public class SocialMediumDTO {

    private int databaseID;			    // A unique identification number in the database.
    private String name;			    // The business name of the social medium.
    private String website; 			// The website address for the social medium.
    private String accountPrefix;		// The prefix address into which the account can be completed.
    private String icon;			    // Icon associated to the particular social medium.
    private boolean isActiveYN;         // Flag marked positevely if the medium is still considered active.
    private int importanceRank;         // Importance rank in order to have some always in the beginning of lists, e.g. Facebook vs. MySpace.
    private Date insertDate;            // The date on which the social medium was first persisted.
    private Date updateDate;            // The date on which the social medium was last updated.

    /**************************************  Constructors   ***********************************************/
    public SocialMediumDTO( ) {
        super();
    }

    public SocialMediumDTO(int databaseID, String name, String website, String accountPrefix, String icon, boolean isActiveYN, int importanceRank) {
        this.databaseID = databaseID;
        this.name = name;
        this.website = website;
        this.accountPrefix = accountPrefix;
        this.icon = icon;
        this.isActiveYN = isActiveYN;
        this.importanceRank = importanceRank;
        // Note that insert and update dates are not handled by the constructor.
    }

    /***************************************   Getters and Setters   ***************************************/
    public int getDatabaseID() {
        return databaseID;
    }

    public void setDatabaseID(int databaseID) {
        this.databaseID = databaseID;
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

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
