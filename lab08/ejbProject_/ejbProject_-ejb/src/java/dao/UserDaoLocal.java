package dao;

import java.util.List;
import javax.ejb.Remote;
import model.User;

@Remote
public interface UserDaoLocal {
    public List<User> getAllUser();
    public boolean Delete(int id);
    public User getById(int id) ;
    public boolean editUser(User user);
    public boolean insertUser(User user);
}
