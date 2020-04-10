/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.ClassGroup;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Лера
 */
@Local
public interface GroupSessionBeanLocal {
    public List<ClassGroup> findAll();
    public void create(ClassGroup g);
    public void edit(ClassGroup g);
    public void remove(ClassGroup g);
    public ClassGroup find(int id);
}
