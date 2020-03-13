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
        <title>Главная страница</title>
        <style>
            input{
                width: 250px;
                background: antiquewhite;
                border: 0;
            }
            </style>
    </head>
    <body>
        <form action = "user" method="get">
            <input type="submit" value="Список пользователей">
        </form>
        <br>
        <form action = "addUser" method="get">
            <input type="hidden" name="go" value="add">
            <input type="submit" value="Добавить пользователя">
        </form>
        <br>
        <form action = "statistics" method="get">
            <input type="submit" value="Статистика">
        </form>
        <br>
        <form action = "addUser" method="get">
            <input type="hidden" name="go" value="show">
            <input type="submit" value="Список добавленных пользователей">
        </form>
    </body>
</html>
