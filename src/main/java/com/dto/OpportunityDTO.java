package com.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OpportunityDTO {

    private int databaseID;                                            // A unique identification number in the database.
    private String greekTitle = null;                                  // A title for the Opportunity in Greek.
    private String englishTitle = null;                                // A title for the Opportunity in English.
    private String greekSummary = null;                                // A short description for the Opportunity in Greek.
    private String englishSummary = null;                              // A short description for the Opportunity in English.
    private String greekDescription = null;                            // A description for the Opportunity in Greek.
    private String englishDescription = null;                          // A description for the Opportunity in English.
    private String contactPerson = null;                               // The person to contact regarding the opportunity.
    private String contactPersonEmail = null;                          // The e-mail of the person to contact for the opportunity.
    private String imagePath = null;                                   // The path where the image can be loaded from.
    private Date addDate = null;                                       // The date the opportunity was first published.
    private Date updateDate = null;                                    // The date the opportunity was last updated.
    private Date openDate = null;                                      // The date the opportunity first became valid.
    private Date closeDate = null;                                     // The date the opportunity was considered redundant.
    private boolean isTrainingProvidedYN = false;                      // Marked positively if training shall be provided for the volunteer.
    private boolean isHiddenYN = false;                                // Marked positively if the opportunity no longer appears on the website.
    private boolean isOpenYN = false;                                  // Marked positively if opportunity is still considered open for applications.
    private boolean isEthelonYN = false;                               // Marked positively if the opportunity is belongs to Ethelon.
    private List<ApplicationDTO> applicationsList;                     // A list of applications associated with the opportunity.
    private List<KnowledgeAreaDTO> knowledgeAreasList;                 // A list of knowledge areas the applying volunteer must be familiar with.
    private List<InterestDTO> secondaryCategoriesList;                 // A list of secondary categories one may relate the Opportunity to.
    private NgoDTO ngo;                                                // The Ngo that originally posted the Opportunity.
    private AreaDTO area;                                              // The Area where the Opportunity takes place at.
    private InterestDTO primarycategory;                               // The main category one may relate the Opportunity to.
    private QuestionnaireDTO questionnaire;                            // A Questionnaire the Volunteer must answer when applying for an Opportunity.

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Constructors ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public OpportunityDTO( ) {
        super();
    }

    public OpportunityDTO(int databaseID, String greekTitle, String englishTitle, String greekSummary, String englishSummary,
                          String greekDescription, String englishDescription, String contactPerson, String contactPersonEmail,
                          String imagePath, Date addDate, Date updateDate, Date openDate, Date closeDate, boolean isTrainingProvidedYN,
                          boolean isHiddenYN, boolean isOpenYN, boolean isEthelonYN, Object o1, Object o, List<ApplicationDTO> applicationsList,
                          List<KnowledgeAreaDTO> knowledgeAreasList, List<InterestDTO> secondaryCategoriesList, NgoDTO ngo, AreaDTO area,
                          InterestDTO primarycategory, QuestionnaireDTO questionnaire) {

        this.databaseID = databaseID;
        this.greekTitle = greekTitle;
        this.englishTitle = englishTitle;
        this.greekSummary = greekSummary;
        this.englishSummary = englishSummary;
        this.greekDescription = greekDescription;
        this.englishDescription = englishDescription;
        this.contactPerson = contactPerson;
        this.contactPersonEmail = contactPersonEmail;
        this.imagePath = imagePath;
        this.addDate = addDate;
        this.updateDate = updateDate;
        this.openDate = openDate;
        this.closeDate = closeDate;
        this.isTrainingProvidedYN = isTrainingProvidedYN;
        this.isHiddenYN = isHiddenYN;
        this.isOpenYN = isOpenYN;
        this.isEthelonYN = isEthelonYN;
        this.applicationsList = applicationsList;
        this.knowledgeAreasList = knowledgeAreasList;
        this.secondaryCategoriesList = secondaryCategoriesList;
        this.ngo = ngo;
        this.area = area;
        this.primarycategory = primarycategory;
        this.questionnaire = questionnaire;
    }

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Getters and Setters ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    public int getDatabaseID() {
        return databaseID;
    }

    public void setDatabaseID(int databaseID) {
        this.databaseID = databaseID;
    }

    public String getGreekTitle() {
        return greekTitle;
    }

    public void setGreekTitle(String greekTitle) {
        this.greekTitle = greekTitle;
    }

    public String getEnglishTitle() {
        return englishTitle;
    }

    public void setEnglishTitle(String englishTitle) {
        this.englishTitle = englishTitle;
    }

    public String getGreekSummary() {
        return greekSummary;
    }

    public void setGreekSummary(String greekSummary) {
        this.greekSummary = greekSummary;
    }

    public String getEnglishSummary() {
        return englishSummary;
    }

    public void setEnglishSummary(String englishSummary) {
        this.englishSummary = englishSummary;
    }

    public String getGreekDescription() {
        return greekDescription;
    }

    public void setGreekDescription(String greekDescription) {
        this.greekDescription = greekDescription;
    }

    public String getEnglishDescription() {
        return englishDescription;
    }

    public void setEnglishDescription(String englishDescription) {
        this.englishDescription = englishDescription;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getContactPersonEmail() {
        return contactPersonEmail;
    }

    public void setContactPersonEmail(String contactPersonEmail) {
        this.contactPersonEmail = contactPersonEmail;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    public Date getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Date closeDate) {
        this.closeDate = closeDate;
    }

    public boolean isTrainingProvidedYN() {
        return isTrainingProvidedYN;
    }

    public void setTrainingProvidedYN(boolean trainingProvidedYN) {
        isTrainingProvidedYN = trainingProvidedYN;
    }

    public boolean isHiddenYN() {
        return isHiddenYN;
    }

    public void setHiddenYN(boolean hiddenYN) {
        isHiddenYN = hiddenYN;
    }

    public boolean isOpenYN() {
        return isOpenYN;
    }

    public void setOpenYN(boolean openYN) {
        isOpenYN = openYN;
    }

    public boolean isEthelonYN() {
        return isEthelonYN;
    }

    public void setEthelonYN(boolean ethelonYN) {
        isEthelonYN = ethelonYN;
    }

    public List<ApplicationDTO> getApplicationsList() {
        if (applicationsList == null) applicationsList = new ArrayList<ApplicationDTO>();
        return applicationsList;
    }

    public void setApplicationsList(List<ApplicationDTO> applicationsList) {
        this.applicationsList = applicationsList;
    }

    public List<KnowledgeAreaDTO> getKnowledgeAreasList() {
        if (knowledgeAreasList == null) knowledgeAreasList = new ArrayList<KnowledgeAreaDTO>();
        return knowledgeAreasList;
    }

    public void setKnowledgeAreasList(List<KnowledgeAreaDTO> knowledgeAreasList) {
        this.knowledgeAreasList = knowledgeAreasList;
    }

    public List<InterestDTO> getSecondaryCategoriesList() {
        if (secondaryCategoriesList == null) secondaryCategoriesList = new ArrayList<InterestDTO>();
        return secondaryCategoriesList;
    }

    public void setSecondaryCategoriesList(List<InterestDTO> secondaryCategoriesList) {
        this.secondaryCategoriesList = secondaryCategoriesList;
    }

    public NgoDTO getNgo() {
        return ngo;
    }

    public void setNgo(NgoDTO ngo) {
        this.ngo = ngo;
    }

    public AreaDTO getArea() {
        return area;
    }

    public void setArea(AreaDTO area) {
        this.area = area;
    }

    public InterestDTO getPrimarycategory() {
        return primarycategory;
    }

    public void setPrimarycategory(InterestDTO primarycategory) {
        this.primarycategory = primarycategory;
    }

    public QuestionnaireDTO getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(QuestionnaireDTO questionnaire) {
        this.questionnaire = questionnaire;
    }
} // End of OpportunityDTO class.
