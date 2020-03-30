package controllers;

import bean.RoleSessionBeanLocal;
import bean.UserSessionBeanLocal;
import entities.Role;
import entities.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class editUser extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet editUser</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet editUser at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @EJB
    UserSessionBeanLocal userSBL;
    
    @EJB
    RoleSessionBeanLocal roleSBL;
    User u;
            
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        u = userSBL.find(id);
        request.setAttribute("user", u);
        List<Role> roleList = roleSBL.findAll();
        request.setAttribute("roleList", roleList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("editUser.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        u.setLogin(request.getParameter("login"));        
        Role role = roleSBL.find(Integer.parseInt(request.getParameter("role")));
        u.setRole(role);
        userSBL.edit(u);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
