package bean;

import entities.ClassGroup;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import static javax.ejb.TransactionAttributeType.REQUIRED;

@Stateless
public class SessionBeanForRollBack implements SessionBeanForRollBackLocal {
    
    @Resource
    private SessionContext context;
    
    @EJB
    GroupSessionBeanLocal groupSBL;
    
    @TransactionAttribute(REQUIRED)
    public void Rollback(){
        
        ClassGroup group = new ClassGroup();
        group.setName("ggg");
        group.setDescription("d");
        group.setNumberOfStudents(3);
        try{
            groupSBL.create(group);
        }catch(Exception ex){
            Logger.getLogger(SessionBeanForTransaction.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        context.setRollbackOnly();
    }
}
