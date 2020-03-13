package model;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

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

    
    public User() {
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int UserID) {
        this.userID = UserID;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String Login) {
        this.login = Login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String Password) {
        this.password = Password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String Email) {
        this.email = Email;
    }

    public Date getbDate() {
        return bDate;
    }

    public void setbDate(Date bDate) {
        this.bDate = bDate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
