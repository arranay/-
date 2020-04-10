package bean;

import entities.ClassGroup;
import entities.User;
import javax.ejb.Local;

@Local
public interface SessionBeanForTransactionLocal {
    public void addUserAndGroup();
    public void addGroupList(ClassGroup g);
    public void addUserList(User u);
    public void addUserEditList(User u);
}
