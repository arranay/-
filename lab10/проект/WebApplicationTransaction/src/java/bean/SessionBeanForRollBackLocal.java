package bean;

import javax.ejb.Local;

@Local
public interface SessionBeanForRollBackLocal {
    public void Rollback();
}
