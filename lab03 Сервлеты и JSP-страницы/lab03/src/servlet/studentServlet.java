package servlet;

import dao.GrooupeDAO;
import dao.StudentDAO;
import modelDao.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class studentServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        StudentDAO studentDAO = new StudentDAO();
        List<Student> studentList = studentDAO.getAll();
        request.setAttribute("studentList", studentList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("studentList.jsp");
        requestDispatcher.forward(request, response);

    }
}
