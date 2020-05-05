package singlton;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class interceptor implements Serializable{
    
    @EJB
    countAddUser caUser;
    
    @AroundInvoke 
    public Object addInter(InvocationContext context) throws Exception{
        caUser.plus();
        return context.proceed();
    }
}
