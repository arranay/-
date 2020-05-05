/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllersGroup;

import bean.GroupSessionBeanLocal;
import entities.ClassGroup;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Лера
 */
public class groupList extends HttpServlet {

    @EJB
    GroupSessionBeanLocal groupSBL;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try{
            List<ClassGroup> groupList = groupSBL.findAll();
            request.setAttribute("groupList", groupList);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("groupList.jsp");
            requestDispatcher.forward(request, response);
        }catch (IOException | ServletException e) { 
            throw new ServletException(e.getMessage()); 
        }  
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ClassGroup g = groupSBL.find(id);
        groupSBL.remove(g);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(request, response);
    }
}
