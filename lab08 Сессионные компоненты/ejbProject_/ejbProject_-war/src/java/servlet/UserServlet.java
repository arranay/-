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

public class UserServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UserServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UserServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    @EJB 
    private UserDaoLocal userDao;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            List<User> userList = userDao.getAllUser();
            request.setAttribute("userList", userList);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("userList.jsp");
            requestDispatcher.forward(request, response);
        }catch (Exception e) { 
            throw new ServletException(e.getMessage()); 
        }    
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {    
        RequestDispatcher dispatcher;
        int id = Integer.parseInt(request.getParameter("id"));
        userDao.Delete(id);
        dispatcher=request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
