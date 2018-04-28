package com.database;

import javax.persistence.*;

@Table(name = "user")
@Entity(name="User")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "User_Type")

public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)                  // A unique identification number in the database.
    private int userID;

    @Column(name="UserName")                                                   // A unique string identifier for the user. Part of the credentials.
    private String username = null;

    @Column(name="PassWord")                                                   // A unique string identifier for the user. Part of the credentials.
    private String password = null;

    @Column(name="Telephone")                                                  // A user's telephone number.
    private String telephone = null;

    @Column(name="Email")                                                      // A user's e-mail address.
    private String email = null;

    @Column(name="LoggedInLast")                                               // Latest date of log-in.
    private String loggedInLast = null;

    @Column(name="AccountCreated")                                             // The date on which the user account has been created.
    private String accountCreated = null;

    @Column(name="AccountUpdated")                                             // The date on which the user account has last been updated.
    private String accountUpdated = null;

    /**************************************  Constructors   ***********************************************/
    public User( ) {
        super();
    }

    public User(String username, String password, String telephone, String email, String loggedInLast, String accountCreated, String accountUpdated) {
        this.username = username;
        this.password = password;
        this.telephone = telephone;
        this.email = email;
        this.loggedInLast = loggedInLast;
        this.accountCreated = accountCreated;
        this.accountUpdated = accountUpdated;
    }

    /***************************************   Getters and Setters   ***************************************/
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
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

    public String getLoggedInLast() {
        return loggedInLast;
    }

    public void setLoggedInLast(String loggedInLast) {
        this.loggedInLast = loggedInLast;
    }

    public String getAccountCreated() {
        return accountCreated;
    }

    public void setAccountCreated(String accountCreated) {
        this.accountCreated = accountCreated;
    }

    public String getAccountUpdated() {
        return accountUpdated;
    }

    public void setAccountUpdated(String accountUpdated) {
        this.accountUpdated = accountUpdated;
    }
}





