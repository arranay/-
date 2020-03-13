package statefullBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;

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
