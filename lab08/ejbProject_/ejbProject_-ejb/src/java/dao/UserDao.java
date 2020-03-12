/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.sql.DataSource;
import singlton.countAddUser;

/**
 *
 * @author Лера
 */
@Stateless
public class UserDao implements UserDaoLocal {
    
    //@Resource("jdbc/buymypoem")
    //private DataSource dataSource;
    
   private static String url = "jdbc:mysql://localhost:3306/buymypoem?useSSL=false&useUnicode=true&serverTimezone=Europe/Moscow";
   private static String username = "root";    
   private static String password = "";
   private String query;


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
                /* con = /*dataSource.getConnection();*/
            
             Connection con = DriverManager.getConnection(url, username, password);
             Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(query);) {
            while (rs.next()) {
                User user = new User(rs.getInt("UserId"), rs.getString("login"),
                        rs.getString("password"), rs.getString("email"), 
                        rs.getDate("birthdate"), rs.getString("role"));
                userList.add(user);
            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
        return userList; 
    }   

    @Override
    public boolean Delete(int id) {
        query = "delete from user where userId=" + id +";";
        try (Connection con = DriverManager.getConnection(url, username, password)) {
            if(con.prepareStatement(query).executeUpdate()>0) return true;
        }catch (SQLException sqlEx){
            sqlEx.printStackTrace();
        }
        return false;
    }
    
    @Override
    public User getById(int id) {
       User user = null;
       query = "select*from user where userId = " + id + ";";
       try { 
           Class.forName("com.mysql.cj.jdbc.Driver");
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
       }
        try (  
                /* con = /*dataSource.getConnection();*/
            
             Connection con = DriverManager.getConnection(url, username, password);
             Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(query);) {
            while (rs.next()) {
                user = new User(rs.getInt("UserId"), rs.getString("login"),
                        rs.getString("password"), rs.getString("email"), 
                        rs.getDate("birthdate"), rs.getString("role"));
            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
        return user; 
    } 

    @Override
    public boolean editUser(User user) {
        query = "update user set login='"+ user.getLogin() + "', "
                + "password='"+ user.getPassword() + "', "
                + "email='"+ user.getEmail() + "' "
                + "where userID=" +user.getUserID() + ";";
        try (Connection con = DriverManager.getConnection(url, username, password)) {
            if(con.prepareStatement(query).executeUpdate()>0)return true;
        }catch (SQLException sqlEx){
            sqlEx.printStackTrace();
        }
        return false;
    }
    
    
    
    @Override
    public boolean insertUser(User user) {
        
         query = "insert into user (login, email, password, birthdate) " +
                "values (?, ?, ?, ?);";
         
        try(Connection con = DriverManager.getConnection(url, username, password)){
            PreparedStatement pStmt = con.prepareStatement(query);
            pStmt.setString(1, user.getLogin());
            pStmt.setString(2, user.getEmail());
            pStmt.setString(3, user.getPassword());
            pStmt.setDate(4,new java.sql.Date(user.getbDate().getTime()));
            if (pStmt.executeUpdate()>0) return true;
        }catch (SQLException sqlEx){
            sqlEx.printStackTrace();
       }
        return false;    
    }
}
