package dao;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface DAO<T> {
    public abstract boolean insert(T obj) throws NamingException, SQLException;
    public abstract T getById(int id) throws NamingException, SQLException;
    public abstract boolean update(T obj) throws NamingException, SQLException;
    public abstract boolean delete(int id) throws NamingException, SQLException;
    public abstract List<T> getAll() throws NamingException, SQLException;
}
