/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.UserDaoLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

/**
 *
 * @author Лера
 */
public class UserEdit extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UserEdit</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UserEdit at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    @EJB 
    private UserDaoLocal userDao;
        
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       try{
            int id = Integer.parseInt(request.getParameter("id"));
            User user = userDao.getById(id);
            request.setAttribute("user", user);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("userUpdate.jsp");
            requestDispatcher.forward(request, response);
        }catch (Exception e) { 
            throw new ServletException(e.getMessage()); 
        } 
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (!(request.getParameter("newPass").equals(request.getParameter("newPass2")))){
            request.setAttribute("error", "Пароли не совпадают");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("error.jsp");
            requestDispatcher.forward(request, response);
        }
        
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userDao.getById(id);
        if (!(user.getPassword().equals(request.getParameter("pass1")))){
            request.setAttribute("error", "Старый пароль не совпал");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("error.jsp");
            requestDispatcher.forward(request, response);
        }
        user.setLogin(request.getParameter("newLogin"));
        user.setEmail(request.getParameter("newEmail"));
        user.setPassword(request.getParameter("newPass"));
        userDao.editUser(user);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
