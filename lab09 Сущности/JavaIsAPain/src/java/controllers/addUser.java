package controllers;

import bean.RoleSessionBeanLocal;
import bean.UserSessionBeanLocal;
import entities.Role;
import entities.User;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class addUser extends HttpServlet {
    @EJB
    RoleSessionBeanLocal roleSBL;
        
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try{
            List<Role> roleList = roleSBL.findAll();
            request.setAttribute("roleList", roleList);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("addUser.jsp");
            requestDispatcher.forward(request, response);
        }catch (Exception e) { 
            throw new ServletException(e.getMessage()); 
        }  
    }

    @EJB
    UserSessionBeanLocal userSBL;
        
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (!(request.getParameter("password").equals(request.getParameter("password2")))){
            request.setAttribute("error", "Пароли не совпадают");
            List<Role> roleList = roleSBL.findAll();
            request.setAttribute("roleList", roleList);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("addUser.jsp");
            requestDispatcher.forward(request, response);
        }
       User user = new User();
       user.setLogin(request.getParameter("login"));
       user.setPassword(request.getParameter("password"));
       Role role = roleSBL.find(Integer.parseInt(request.getParameter("role")));
       user.setRole(role);
       userSBL.create(user);
       RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
       requestDispatcher.forward(request, response);
    }
}
