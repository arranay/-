/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statefullBean;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author Лера
 */
@Stateful
@SessionScoped
public class StatefullBean implements StatefullBeanLocal, Serializable {
    
    private List<String> loginList = new ArrayList<>();;
  
    @PostConstruct
    private void init(){
        loginList = new ArrayList<>();
    }

    @Override
    public void addLogin(String login){
        loginList.add(login);
    }

    @Override
    public List<String> returnList() {
        return loginList;
    }    
}
