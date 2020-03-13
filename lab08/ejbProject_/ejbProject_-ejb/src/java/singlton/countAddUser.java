package singlton;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

@Singleton
public class countAddUser{
    
    int count;

    @PostConstruct
    public void init() {
        count = 0;
    }

    public int getCount() {
        return count;
    }
    
    public void plus(){
        count++;
    }

}
