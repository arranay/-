<%--
  Created by IntelliJ IDEA.
  User: Лера
  Date: 06.11.2019
  Time: 6:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Сервлеты и JSP-страницы</title>
  <style>
    input{
      color: aliceblue;
      background: black;
      width: 200px;
      height: 40px;
    }
  </style>
</head>
<body>
<div align="center">
  <br>
  <h2 align="center">Выберите таблицу</h2>
  <br>
  <form action = "group" method="get">
    <input type="submit" value="Список групп">
  </form>
  <form action = "student" method="get">
    <input type="submit" value="Список студентов">
  </form>
</div>
</body>
</html>
