<%--
  Created by IntelliJ IDEA.
  User: Лера
  Date: 05.11.2019
  Time: 13:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Список студентов</title>
    <style>
        input{
            color: aliceblue;
            background: black;
            width: 200px;
            height: 40px;
        }
        td{
            width: 200px;
            height: 40px;
            font-size: 20px;
        }
    </style>
</head>
<body>
<br>
<h2 align="center">Список студентов</h2><br>
<table align="center">
    <tr>
        <td>ID</td>
        <td>Группа</td>
        <td>Фамилия</td>
        <td>Имя</td>
        <td>Дата рождения</td>
        <td>Возраст</td>
    </tr>
    <c:forEach var = "st" items="${studentList}">
        <tr>
            <td>${st.getId()}</td>
            <td>${st.getGrooupe()}</td>
            <td>${st.getLastName()}</td>
            <td>${st.getFirstName()}</td>
            <td>${st.getBirthDate()}</td>
            <td>${st.getAge()}</td>
        </tr>
    </c:forEach>
<tr>
<td><br>
<form action = "index.jsp">
    <input type="submit" value="Назад">
</form></td> <td></td><td></td><td>
</td><td></td></tr></table>
</body>
</html>
