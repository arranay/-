package bean;

import entities.ClassGroup;
import entities.User;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;

@Singleton
@TransactionManagement(TransactionManagementType.BEAN)
public class SessionBeanForTransaction implements SessionBeanForTransactionLocal {

    List<User> userList = new ArrayList<User>();
    List<User> userEditList = new ArrayList<User>();
    List<ClassGroup> groupList = new ArrayList<ClassGroup>();

    @Override
    public void addUserList(User u) {
        userList.add(u);
    }

    @Override
    public void addGroupList(ClassGroup g) {
        groupList.add(g);
    }
    
    @Override
    public void addUserEditList(User u) {
        userEditList.add(u);
    }

    @Resource javax.transaction.UserTransaction ut;
    
    @EJB
    GroupSessionBeanLocal groupSBL;
    
    @EJB
    UserSessionBeanLocal userSBL;
    
    
    //добавление в бд пользователей
    public void addUserAndGroup(){
        try {
        ut.begin();
        for(User u: userList){
            userSBL.create(u);
        }
        for(User u: userEditList){
            userSBL.edit(u);
        }
        ut.commit();
        
        ut.begin();
        for (ClassGroup g: groupList){
            groupSBL.create(g);
        }
        ut.commit();
        
        } catch (Exception ex) {
            Logger.getLogger(SessionBeanForTransaction.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            userList=new ArrayList<User>();
            userEditList = new ArrayList<User>();
            groupList = new ArrayList<ClassGroup>();
        }
    }  
}
