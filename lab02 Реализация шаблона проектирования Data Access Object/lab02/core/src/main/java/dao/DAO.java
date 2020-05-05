package dao;

import java.util.ArrayList;

public interface DAO<T> {
    public abstract boolean insert(T obj);
    public abstract T getById(int id);
    public abstract boolean update(T obj);
    public abstract boolean delete(int id);
    public abstract ArrayList<T> getAll();
}
