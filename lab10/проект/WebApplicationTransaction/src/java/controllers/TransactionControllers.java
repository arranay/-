package controllers;

import bean.SessionBeanForRollBackLocal;
import bean.SessionBeanForTransactionLocal;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

   
public class TransactionControllers extends HttpServlet {

    @EJB
    SessionBeanForTransactionLocal sbForTransaction;
    
    @EJB
    SessionBeanForRollBackLocal sbForRollBack;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        sbForTransaction.addUserAndGroup(); 
        sbForRollBack.Rollback();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(request, response);
    }
}