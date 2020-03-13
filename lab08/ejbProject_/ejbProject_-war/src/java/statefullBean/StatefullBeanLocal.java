package statefullBean;

import java.util.List;
import javax.ejb.Local;

@Local
public interface StatefullBeanLocal {
    
    public void addLogin(String login);
    public List<String> returnList();
}
