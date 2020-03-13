/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statefullBean;

import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Лера
 */
@Local
public interface StatefullBeanLocal {
    
    public void addLogin(String login);
    public List<String> returnList();
}
