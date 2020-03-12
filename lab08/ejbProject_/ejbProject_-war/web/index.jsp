<%-- 
    Document   : index
    Created on : 10.03.2020, 19:22:09
    Author     : Лера
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action = "user" method="get">
            <input type="submit" value="Список пользователей">
        </form>
        <br>
        <form action = "addUser" method="get">
            <input type="submit" value="Добавить пользователя">
        </form>
    </body>
</html>
