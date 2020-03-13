package singlton;

import javax.ejb.EJB;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class interceptorUpdate {
    
    @EJB
    countUpdateUser caUser;
    
    @AroundInvoke 
    public Object addInter(InvocationContext context) throws Exception{
        caUser.plus();
        return context.proceed();
    }
}
