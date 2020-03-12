/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.User;

/**
 *
 * @author Лера
 */
public class NewClass {
    public static void main(String args[ ])
      {
          UserDao ud = new UserDao();
          List<User> userList = ud.getAllUser();
          
          for (User u: userList){
              System.out.print(u.getLogin());
          }
      }
    
}
