package com.database;

import javax.persistence.*;
import java.util.Date;

@Table(name = "user")
@Entity(name="User")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "User_Type")
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private int userID;

    @Column(name="UserName")
    private String username = null;

    @Column(name="PassWord")
    private String password = null;

    @Column(name="Telephone")
    private String telephone = null;

    @Column(name="Email")
    private String email = null;

    @Column(name="LoggedInLast")
    private String loggedInLast = null;

    @Column(name="AccountCreated")
    private String accountCreated = null;

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
}





