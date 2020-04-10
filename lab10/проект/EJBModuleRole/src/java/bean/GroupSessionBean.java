/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.ClassGroup;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Лера
 */
@Stateless
public class GroupSessionBean implements GroupSessionBeanLocal {

    @PersistenceContext(unitName = "EJBModuleGroupPU")
    private EntityManager em;
     
    @Override
    public List<ClassGroup> findAll() {
        List <ClassGroup> groupList
                =em.createQuery("SELECT g FROM ClassGroup g").getResultList();
        return groupList;
    }

    @Override
    public void create(ClassGroup g) {
        em.persist(g);
    }

    @Override
    public void edit(ClassGroup g) {
        em.merge(g);
    }

    @Override
    public void remove(ClassGroup g) {
        em.remove(em.merge(g));
    }
     

    @Override
    public ClassGroup find(int id) {
        return em.find(ClassGroup.class, id);
    }   
}
