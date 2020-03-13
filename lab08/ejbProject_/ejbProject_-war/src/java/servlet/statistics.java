package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import singlton.countAddUser;
import singlton.countDeleteUser;
import singlton.countUpdateUser;

public class statistics extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet statistics</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet statistics at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    @EJB
    private countDeleteUser cdUser;
    
    @EJB
    private countUpdateUser cuUser;
    
    @EJB
    private countAddUser caUser;
    
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            request.setAttribute("delete", cdUser.getCount());
            request.setAttribute("update", cuUser.getCount());
             request.setAttribute("add", caUser.getCount());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("statistics.jsp");
            requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}