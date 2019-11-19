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
<h2 align="center"><c:out value="Список групп" /></h2>
<br>
<table align="center">
    <tr>
        <td><c:out value="ID" /></td>
        <td><c:out value="Название группы" /></td>
        <td><c:out value="Дата создания" /></td>
        <td><c:out value="Куратор" /></td>
    </tr>
<c:forEach items="${gropeList}" var="gr">
            <tr>
                <td><c:out value="${gr.getId()}" /></td>
                <td><c:out value="${gr.getGroupName()}" /></td>
                <td><c:out value="${gr.getCreationDate()}" /></td>
                <td><c:out value="${gr.getCuratorName()}" /></td>
                <td>
                    <form action = <c:url value="/groupUpdate.jsp" />>
                        <input type="submit" value="Редактировать">
                        <input type="hidden" name="id" value="${gr.getId()}">
                        <input type="hidden" name="groupName" value="${gr.getGroupName()}">
                        <input type="hidden" name="curatorName" value="${gr.getCuratorName()}">
                    </form>
                </td>
                <td>
                    <form action=<c:url value="/groupDelete.jsp" />>
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
<form action = <c:url value="/index.jsp" />>
    <input type="submit" value="Назад">
</form></td>
    <td>
        <form action=<c:url value="/groupAdd.jsp" />>
            <input type="submit" value="Добавить группу">
        </form>
    </td><td></td><td></td><td></td><td></td>
    </tr>
</table>
<center>
    <c:import url="groupAdd.jsp" /></center>
</body>
</html>
