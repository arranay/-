package servlet;

import dao.UserDaoLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;
import statefullBean.StatefullBeanLocal;

public class addUser extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet addUser</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addUser at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    @EJB
    private StatefullBeanLocal slBean;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String go = request.getParameter("go");
                if (go.equals("add")){
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("addUser.jsp");
                    requestDispatcher.forward(request, response);
                }else{
                    List<String> ls = slBean.returnList();
                    request.setAttribute("userList", ls);
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("show.jsp");
                    requestDispatcher.forward(request, response);
                }
    }

    @EJB 
    private UserDaoLocal userDao;
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       if (!(request.getParameter("password").equals(request.getParameter("password2")))){
            request.setAttribute("error", "Пароли не совпадают");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("error.jsp");
            requestDispatcher.forward(request, response);
        }
       User user = new User();
       user.setLogin(request.getParameter("login"));
       user.setEmail(request.getParameter("email"));
       user.setPassword(request.getParameter("password"));
       SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
       String bdate = request.getParameter("bdate");
       try {
                Date date =format.parse(bdate); 
                user.setbDate(date);  
            } catch (ParseException e) {
                    e.printStackTrace();
            }
       if (userDao.insertUser(user)){
           slBean.addLogin(request.getParameter("login"));
       }
       RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
       requestDispatcher.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
