<%-- 
    Document   : index
    Created on : 27.05.2020, 21:36:35
    Author     : Лера
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <form action="JMSServlet" method="POST">
            Текст сообщения:
            <textarea name="text"></textarea>
            <button>Отправить</button>
        </form>
        <form action="JMSServlet" method="GET">
            <button>Получить сообщение из очереди</button>
        </form><br>
        <c:out value="${msg}"/>
    </body>
</html>
