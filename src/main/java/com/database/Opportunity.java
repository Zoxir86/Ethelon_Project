package com.database;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "opportunity")
@Entity(name="Opportunity")

public class Opportunity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id", updatable = false, nullable = false)         // A unique identification number in the database.
    private int opportunityID;

    @Column(name = "GreekTitle")                                      // A title for the Opportunity in Greek.
    private String greekTitle = null;

    @Column(name = "EnglishTitle")                                    // A title for the Opportunity in English.
    private String englishTitle = null;

    @Column(name = "GreekSummary")                                    // A short description for the Opportunity in Greek.
    private String greekSummary = null;

    @Column(name = "EnglishSummary")                                  // A short description for the Opportunity in English.
    private String englishSummary = null;

    @Column(name = "GreekDescription")                                // A description for the Opportunity in Greek.
    private String greekDescription = null;

    @Column(name = "EnglishDescription")                              // A description for the Opportunity in English.
    private String englishDescription = null;

    @Column(name = "ContactPerson")                                   // The person to contact regarding the opportunity.
    private String contactPerson = null;

    @Column(name = "ContactPersonEmail")                              // The e-mail of the person to contact for the opportunity.
    private String contactPersonEmail = null;

    @Column(name = "ImagePath")                                       // The path where the image can be loaded from.
    private String imagePath = null;

    @Column(name = "AddDate")                                         // The date the opportunity was first published.
    private String addDate = null;

    @Column(name = "UpdateDate")                                      // The date the opportunity was last updated.
    private String updateDate = null;

    @Column(name = "OpenDate")                                        // The date the opportunity first became valid.
    private String openDate = null;

    @Column(name = "CloseDate")                                       // The date the opportunity was considered redundant.
    private String closeDate = null;

    @Column(name = "TrainingProvidedYN")                              // Marked positively if training shall be provided for the volunteer.
    private boolean isTrainingProvidedYN = false;

    @Column(name = "HiddenYN")                                        // Marked positively if the opportunity no longer appears on the website.
    private boolean isHiddenYN = false;

    @Column(name = "OpenYN")                                          // Marked positively if opportunity is still considered open for applications.
    private boolean isOpenYN = false;

    @Column(name = "EthelonYN")                                       // Marked positively if the opportunity is belongs to Ethelon.
    private boolean isEthelonYN = false;

    @OneToMany(targetEntity = Application.class)                      // A list of applications associated with the opportunity.
    private List<Application> applicationsList;

    @OneToMany(targetEntity = KnowledgeArea.class)                    // A list of knowledge areas the applying volunteer must be familiar with.
    private List<KnowledgeArea> knowledgeAreasList;

    @OneToMany(targetEntity = Interest.class)                         // A list of secondary categories one may relate the Opportunity to.
    private List<Interest> secondaryCategoriesList;

    @ManyToOne                                                        // The Ngo that originally posted the Opportunity.
    private Ngo ngo;

    @ManyToOne                                                        // The Area where the Opportunity takes place at.
    private Area area;

    @ManyToOne                                                        // The main category one may relate the Opportunity to.
    private Interest primarycategory;

    @OneToOne                                                         // A Questionnaire the Volunteer must answer when applying for an Opportunity.
    private Questionnaire questionnaire;

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Constructors ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public Opportunity() {
        super();
    }

    public Opportunity(String greekTitle, String englishTitle, String greekSummary, String englishSummary, String greekDescription,
                       String englishDescription, String contactPerson, String contactPersonEmail, String imagePath, String addDate,
                       String updateDate, String openDate, String closeDate, boolean isTrainingProvidedYN, boolean isHiddenYN,
                       boolean isOpenYN, boolean isEthelonYN, List<Application> applicationsList, List<KnowledgeArea> knowledgeAreasList,
                       List<Interest> secondaryCategoriesList, Ngo ngo, Area area, Interest primarycategory, Questionnaire questionnaire) {

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
    public int getOpportunityID() {
        return opportunityID;
    }

    public void setOpportunityID(int opportunityID) {
        this.opportunityID = opportunityID;
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

    public String getAddDate() {
        return addDate;
    }

    public void setAddDate(String addDate) {
        this.addDate = addDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getOpenDate() {
        return openDate;
    }

    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }

    public String getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(String closeDate) {
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

    public List<Application> getApplicationsList() {
        if (applicationsList == null) applicationsList = new ArrayList<Application>();
        return applicationsList;
    }

    public void setApplicationsList(List<Application> applicationsList) {
        this.applicationsList = applicationsList;
    }

    public List<KnowledgeArea> getKnowledgeAreasList() {
        if (knowledgeAreasList == null) knowledgeAreasList = new ArrayList<KnowledgeArea>();
        return knowledgeAreasList;
    }

    public void setKnowledgeAreasList(List<KnowledgeArea> knowledgeAreasList) {
        this.knowledgeAreasList = knowledgeAreasList;
    }

    public List<Interest> getSecondaryCategoriesList() {
        return secondaryCategoriesList;
    }

    public void setSecondaryCategoriesList(List<Interest> secondaryCategoriesList) {
        if (secondaryCategoriesList == null) secondaryCategoriesList = new ArrayList<Interest>();
        this.secondaryCategoriesList = secondaryCategoriesList;
    }

    public Ngo getNgo() {
        return ngo;
    }

    public void setNgo(Ngo ngo) {
        this.ngo = ngo;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public Interest getPrimarycategory() {
        return primarycategory;
    }

    public void setPrimarycategory(Interest primarycategory) {
        this.primarycategory = primarycategory;
    }

    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(Questionnaire questionnaire) {
        this.questionnaire = questionnaire;
    }
}
