package bean;

import entities.ClassGroup;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import static javax.ejb.TransactionAttributeType.REQUIRED;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

    @Resource
    private SessionContext context;
        
    @Override
    @TransactionAttribute(REQUIRED)
    public void create(ClassGroup g) {
        em.persist(g);
        if (g.getNumberOfStudents()>100) context.setRollbackOnly();
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
