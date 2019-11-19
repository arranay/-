<%--
  Created by IntelliJ IDEA.
  User: Лера
  Date: 05.11.2019
  Time: 13:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Список группы</title>
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
        text-align: center;
    }
</style>
</head>
<body>
<br>
<h2 align="center">Список группы</h2>
<br>
<table align="center">
    <tr>
        <td>ID</td>
        <td>Название группы</td>
        <td>Дата создания</td>
        <td>Куратор</td>
    </tr>
<c:forEach items="${gropeList}" var="gr">
            <tr>
                <td>${gr.getId()}</td>
                <td>${gr.getGroupName()}</td>
                <td>${gr.getCreationDate()}</td>
                <td>${gr.getCuratorName()}</td>
                <td>
                    <form action = "groupUpdate.jsp">
                        <input type="submit" value="Редактировать">
                        <input type="hidden" name="id" value="${gr.getId()}">
                        <input type="hidden" name="groupName" value="${gr.getGroupName()}">
                        <input type="hidden" name="curatorName" value="${gr.getCuratorName()}">
                    </form>
                </td>
                <td>
                    <form action="groupDelete.jsp">
                        <input type="hidden" name="id" value="${gr.getId()}">
                        <input type="hidden" name="groupName" value="${gr.getGroupName()}">
                        <input type="submit" value="Удалить">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>

<table align="center">
    <tr><td>
<form action = "index.jsp">
    <input type="submit" value="Назад">
</form></td>
    <td>
        <form action="groupAdd.jsp">
            <input type="submit" value="Добавить группу">
        </form>
    </td><td></td><td></td><td></td><td></td>
    </tr>
</table>
</body>
</html>
