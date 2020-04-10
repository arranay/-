package bean;

import entities.ClassGroup;
import entities.User;
import javax.ejb.Local;

@Local
public interface SessionBeanForTransactionLocal {
    //метод для транзакции в бд пользователей
    public void addUser();
    //метод для транзакции в бд групп
    public void addGroup();
    
    public void addGroupList(ClassGroup g);
    public void addUserList(User u);
    public void addUserEditList(User u);
}
