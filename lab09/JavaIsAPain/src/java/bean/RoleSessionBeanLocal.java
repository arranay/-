package bean;

import entities.Role;
import java.util.List;
import javax.ejb.Local;

@Local
public interface RoleSessionBeanLocal {
    public List<Role> findAll();
    public Role find(int id);
}
