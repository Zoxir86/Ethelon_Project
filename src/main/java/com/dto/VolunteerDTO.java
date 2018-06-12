package com.dto;


import java.util.Date;
import java.util.List;


public class VolunteerDTO {

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ As Volunteer ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private String name = null;                                 // A person's first name.
    private String surname = null;                              // A person's surname.
    private Date dateOfBirth = null;                            // A person's birthday.
    private String sex;                                         // A person's sex. Constants provided by the "Sex" class.
    private boolean isVolunteerYN;                              // Marked positively when the person has previous experience as volunteer.
    private boolean isEthelonVolunteerYN;                       // Marked positively when the person has previous experience as volunteer.
    private Date appliedLast = null;                            // Latest date of application.
    private AreaDTO area = null;                                // Accommodation area. Unique areas correspond to postal codes in the database.
    private List<ApplicationDTO> applicationsList;              // Applications history for the person.
    private List<ApplicationDTO> pendingApplicationsList;       // Pending applications for the person.
    private List<InterestDTO> interestsList;                    // Topics in which the person has expressed interest in.
    private List<KnowledgeAreaDTO> knowledgeAreasList;          // Knowledge area in which the person has expressed proficiency in.
    private String otherKnowledge;                              // Knowledge areas as a free string/comment marked as "other".

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ As User ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private int databaseID;                                     // A unique database identification number.
    private String username = null;                             // A unique string identifier for the user. Part of the credentials.
    private String password = null;                             // A unique string identifier for the user. Part of the credentials.
    private String telephone = null;                            // A user's telephone number.
    private String email = null;                                // A user's e-mail address.
    private Date loggedInLast = null;                           // Latest date of log-in.
    private Date accountCreated = null;                         // The date on which the user account has been created.
    private Date accountUpdated = null;                         // The date on which the user account has last been updated.
    private boolean selected;

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Constructors ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public VolunteerDTO( ) {
        super();
    }

    public VolunteerDTO(String name, String surname, Date dateOfBirth, String sex, boolean isVolunteerYN, boolean isEthelonVolunteerYN, Date appliedLast, AreaDTO area, List<ApplicationDTO> applicationsList, List<ApplicationDTO> pendingApplicationsList, List<InterestDTO> interestsList, List<KnowledgeAreaDTO> knowledgeAreasList, String otherKnowledge, int databaseID, String username, String password, String telephone, String email, Date loggedInLast, Date accountCreated, Date accountUpdated) {
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

    public Date getAppliedLast() {
        return appliedLast;
    }

    public void setAppliedLast(Date appliedLast) {
        this.appliedLast = appliedLast;
    }

    public AreaDTO getArea() {
        return area;
    }

    public void setArea(AreaDTO area) {
        this.area = area;
    }

    public List<ApplicationDTO> getApplicationsList() {
        return applicationsList;
    }

    public void setApplicationsList(List<ApplicationDTO> applicationsList) {
        this.applicationsList = applicationsList;
    }

    public List<ApplicationDTO> getPendingApplicationsList() {
        return pendingApplicationsList;
    }

    public void setPendingApplicationsList(List<ApplicationDTO> pendingApplicationsList) {
        this.pendingApplicationsList = pendingApplicationsList;
    }

    public List<InterestDTO> getInterestsList() {
        return interestsList;
    }

    public void setInterestsList(List<InterestDTO> interestsList) {
        this.interestsList = interestsList;
    }

    public List<KnowledgeAreaDTO> getKnowledgeAreasList() {
        return knowledgeAreasList;
    }

    public void setKnowledgeAreasList(List<KnowledgeAreaDTO> knowledgeAreasList) {
        this.knowledgeAreasList = knowledgeAreasList;
    }

    public String getOtherKnowledge() {
        return otherKnowledge;
    }

    public void setOtherKnowledge(String otherKnowledge) {
        this.otherKnowledge = otherKnowledge;
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

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
