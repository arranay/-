/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Лера
 */
public class User {

    public User() {
        
    }

    /**
     * @return the UserID
     */
    public int getUserID() {
        return userID;
    }

    /**
     * @param UserID the UserID to set
     */
    public void setUserID(int UserID) {
        this.userID = UserID;
    }

    /**
     * @return the Login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param Login the Login to set
     */
    public void setLogin(String Login) {
        this.login = Login;
    }

    /**
     * @return the Password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param Password the Password to set
     */
    public void setPassword(String Password) {
        this.password = Password;
    }

    /**
     * @return the Email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param Email the Email to set
     */
    public void setEmail(String Email) {
        this.email = Email;
    }
    
    private int userID;
    private String login;
    private String password;
    private String email;
    private Date bDate;
    private String role;
    
    public User(int id, String login, String password, String email, Date date, String role){
        userID=id;
        this.login=login;
        this.email=email;
        this.password=password;
        bDate = date;
        this.role = role;
    }

    /**
     * @return the bDate
     */
    public Date getbDate() {
        return bDate;
    }

    /**
     * @param bDate the bDate to set
     */
    public void setbDate(Date bDate) {
        this.bDate = bDate;
    }

    /**
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(String role) {
        this.role = role;
    }
}
