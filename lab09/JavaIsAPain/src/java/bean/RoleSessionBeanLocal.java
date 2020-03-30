/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.Role;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Лера
 */
@Local
public interface RoleSessionBeanLocal {
    public List<Role> findAll();
    public Role find(int id);
}
