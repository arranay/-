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
        <td><c:out value="ID" /></td>
        <td><c:out value="Группа" /></td>
        <td><c:out value="Фамилия" /></td>
        <td><c:out value="Имя" /></td>
        <td><c:out value="Дата рождения" /></td>
        <td><c:out value="Возраст" /></td>
    </tr>
    <c:set var="eitStud" scope = "session" value="${0}" />

    <c:forEach var = "st" items="${studentList}">
        <tr>
            <td><c:out value="${st.getId()}" /></td>
            <td><c:out value="${st.getGrooupe()}" /></td>
            <td><c:out value="${st.getLastName()}" /></td>
            <td><c:out value="${st.getFirstName()}" /></td>
            <td><c:out value="${st.getBirthDate()}" /></td>
            <td><c:out value="${st.getAge()}" /></td>
            <c:if test="${st.getAge()>18}">
                <c:set var="eitStud" scope = "session" value="${eitStud+1}" />
            </c:if>
        </tr>
    </c:forEach>
<tr>
<td><br>
<form action = <c:url value="/index.jsp" />>
    <input type="submit" value="Назад">
</form></td> <td> </td><td></td><td>
</td><td><b><c:out value="Кол-во совершеннолетних студентов: ${eitStud}" /></b>></td></tr></table>
</body>
</html>
