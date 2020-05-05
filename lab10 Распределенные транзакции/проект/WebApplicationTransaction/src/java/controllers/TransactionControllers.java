package controllers;

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
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        RequestDispatcher requestDispatcher;
        if (action.equals("user"))sbForTransaction.addUser(); 
        else sbForTransaction.addGroup();
        requestDispatcher = request.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(request, response);
    }
}