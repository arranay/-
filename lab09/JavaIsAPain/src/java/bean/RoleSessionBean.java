package bean;

import entities.Role;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class RoleSessionBean implements RoleSessionBeanLocal {

    @PersistenceContext(unitName = "JavaIsAPainPU")
    private EntityManager em;
    
    @Override
    public List<Role> findAll() {
        List <Role> roleList
                =em.createQuery("SELECT r FROM Role r").getResultList();
        return roleList;
    }
}
