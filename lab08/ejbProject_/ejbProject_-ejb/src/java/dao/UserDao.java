package dao;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import model.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.interceptor.Interceptors;
import singlton.interceptor;
import singlton.interceptorDelete;
import singlton.interceptorUpdate;

@Stateless
public class UserDao implements UserDaoLocal {
    
   private static String url;
   private static String username; 
   private static String password;
   private String query;
   
   @PostConstruct
   private void init(){
       url = "jdbc:mysql://localhost:3306/buymypoem?"
               + "useSSL=false&useUnicode=true&serverTimezone=Europe/Moscow";
       username = "root";  
       password = "";
   }


    @Override
    public List<User> getAllUser() {
        List<User> userList = new ArrayList<>();
        query = "select*from user;";
       try { 
           Class.forName("com.mysql.cj.jdbc.Driver");
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
       }
        try (  
             Connection con = DriverManager.getConnection(url, username, password);
             Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(query);) {
            while (rs.next()) {
                User user = new User(rs.getInt("UserId"), rs.getString("login"),
                        rs.getString("password"), rs.getString("email"), 
                        rs.getDate("birthdate"), rs.getString("role"));
                userList.add(user);
            }
        } catch (SQLException sqlEx) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, sqlEx);
        }
        return userList; 
    }   

    @Override
    public boolean Delete(int id) {
        query = "delete from user where userId=" + id +";";
        try (Connection con = DriverManager.getConnection(url, username, password)) {
            if(con.prepareStatement(query).executeUpdate()>0) return true;
        }catch (SQLException sqlEx){
             Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, sqlEx);
        }
        return false;
    }
    
    @Override
    @Interceptors(interceptorDelete.class)
    public User getById(int id) {
       User user = null;
       query = "select*from user where userId = " + id + ";";
       try { 
           Class.forName("com.mysql.cj.jdbc.Driver");
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
       }
        try (  
             Connection con = DriverManager.getConnection(url, username, password);
             Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(query);) {
            while (rs.next()) {
                user = new User(rs.getInt("UserId"), rs.getString("login"),
                        rs.getString("password"), rs.getString("email"), 
                        rs.getDate("birthdate"), rs.getString("role"));
            }
        } catch (SQLException sqlEx) {
             Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, sqlEx);
        }
        return user; 
    } 

    @Override
    @Interceptors(interceptorUpdate.class)
    public boolean editUser(User user) {
        query = "update user set login='"+ user.getLogin() + "', "
                + "password='"+ user.getPassword() + "', "
                + "email='"+ user.getEmail() + "' "
                + "where userID=" +user.getUserID() + ";";
       try {
           Class.forName("com.mysql.cj.jdbc.Driver");
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
       }
        try (Connection con = DriverManager.getConnection(url, username, password)) {
            if(con.prepareStatement(query).executeUpdate()>0)return true;
        }catch (SQLException sqlEx){
             Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, sqlEx);
        }
        return false;
    }
    
    
    
    @Override
    @Interceptors(interceptor.class)
    public boolean insertUser(User user) {
        
        query = "insert into user (login, email, password, birthdate) " +
                "values (?, ?, ?, ?);";
       try {
           Class.forName("com.mysql.cj.jdbc.Driver");
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
       }
        try(Connection con = DriverManager.getConnection(url, username, password)){
            PreparedStatement pStmt = con.prepareStatement(query);
            pStmt.setString(1, user.getLogin());
            pStmt.setString(2, user.getEmail());
            pStmt.setString(3, user.getPassword());
            pStmt.setDate(4,new java.sql.Date(user.getbDate().getTime()));
            if (pStmt.executeUpdate()>0) return true;
        }catch (SQLException sqlEx){
             Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, sqlEx);
       }
        return false;    
    }
}
