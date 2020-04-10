package bean;

import entities.ClassGroup;
import entities.User;
import javax.ejb.Local;

@Local
public interface SessionBeanForTransactionLocal {
    public void addUser();
    public void addGroup();
    public void addGroupList(ClassGroup g);
    public void addUserList(User u);
    public void addUserEditList(User u);
}
