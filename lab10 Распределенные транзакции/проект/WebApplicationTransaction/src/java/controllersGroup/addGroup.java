package controllersGroup;

import bean.GroupSessionBeanLocal;
import bean.SessionBeanForTransaction;
import bean.SessionBeanForTransactionLocal;
import entities.ClassGroup;
import java.io.IOException;
import java.io.PrintWriter;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class addGroup extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("addGroup.jsp");
        requestDispatcher.forward(request, response);
    }

    @EJB
    SessionBeanForTransactionLocal sbForTransaction;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        ClassGroup classGroup = new ClassGroup();
        classGroup.setName(request.getParameter("name"));
        classGroup.setDescription(request.getParameter("description"));
        classGroup.setNumberOfStudents(Integer.parseInt(request.getParameter("number")));
        sbForTransaction.addGroupList(classGroup);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(request, response);
    }

}
