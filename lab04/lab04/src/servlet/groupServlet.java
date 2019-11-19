package servlet;

import dao.GrooupDAO;
import modelDao.Grooup;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class groupServlet extends HttpServlet {

    GrooupDAO grooupeDAO = new GrooupDAO();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String param = request.getParameter("go");
        RequestDispatcher dispatcher;

        switch (param){
            case ("CreateGroup"):
                String groupName = request.getParameter("groupName");
                String creationDate = request.getParameter("creationDate");
                String curatorName = request.getParameter("curatorName");
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                Grooup grooup=null;
                try {
                    grooup = new Grooup(groupName, format.parse(creationDate), curatorName);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                grooupeDAO.insert(grooup);
                dispatcher=request.getRequestDispatcher("index.jsp");
                dispatcher.forward(request,response);
                break;
            case ("DeleteGroup"):
                int id = Integer.parseInt(request.getParameter("id"));
                grooupeDAO.delete(id);
                dispatcher=request.getRequestDispatcher("index.jsp");
                dispatcher.forward(request,response);
            case ("UpdateGroup"):
                int id1 = Integer.parseInt(request.getParameter("id1"));
                String groupName1 = request.getParameter("groupName1");
                String curatorName1 = request.getParameter("curatorName1");
                Grooup grooup1= new Grooup();
                grooup1.setCuratorName(curatorName1);
                grooup1.setGroupName(groupName1);
                grooup1.setId(id1);
                grooupeDAO.update(grooup1);
                dispatcher=request.getRequestDispatcher("index.jsp");
                dispatcher.forward(request,response);
                break;
            default:
                dispatcher=request.getRequestDispatcher("index.jsp");
                dispatcher.forward(request,response);
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Grooup> groupList = grooupeDAO.getAll();
        request.setAttribute("gropeList", groupList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("groupList.jsp");
        dispatcher.forward(request, response);
    }
}
