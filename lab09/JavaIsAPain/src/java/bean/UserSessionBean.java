/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Лера
 */
@Stateless
public class UserSessionBean implements UserSessionBeanLocal {
    
    @PersistenceContext(unitName = "JavaIsAPainPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }
    
    @Override
    public List<User> findAll() {
        List <User> userList
                =getEntityManager().createQuery("SELECT u FROM User u").getResultList();
        return userList;
    }
    
    
}
