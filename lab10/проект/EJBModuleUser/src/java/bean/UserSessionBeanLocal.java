package bean;

import entities.User;
import java.util.List;
import javax.ejb.Local;

@Local
public interface UserSessionBeanLocal {
    public List<User> findAll();
    public List<User> findAllStudent();
    public void create(User u);
    public void edit(User u);
    public void remove(User u);
    public User find(int id);
}

