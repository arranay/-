/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.User;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Лера
 */
@Local
public interface UserSessionBeanLocal {
    public List<User> findAll();
    public void create(User u);
    public void edit(User u);
    public void remove(User u);
    public User find(int id);

}
