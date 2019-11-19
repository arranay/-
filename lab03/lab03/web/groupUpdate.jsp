<%--
  Created by IntelliJ IDEA.
  User: Лера
  Date: 05.11.2019
  Time: 17:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Обновить группу</title>
    <style>
        input{
            color: aliceblue;
            background: black;
            width: 200px;
            height: 40px;
        }
        td{
            width: 400px;
            height: 40px;
            font-size: 20px;
        }
    </style>
</head>
<body>
<table>
<form action="group" method="post">
    <input type="hidden" name="go" value="UpdateGroup"/>
    <input type="hidden" name="id1" value="${param.id}">
    <tr>
        <td>Название группы - ${param.groupName} </td>
        <td><input type="text" name="groupName1" /></td>
    </tr>
    <tr>
        <td>Имя куратора - ${param.curatorName} </td>
        <td><input type="text" name="curatorName1"  /></td>
    </tr>
        <tr>
            <td valign="middle">
                <input type="submit" value="Обновить данные">
            </td></tr></form>
<tr><td>
    <form action = "index.jsp">
        <input type="submit" value="Назад">
    </form></td><td></td></tr>
</table>
</body>
</html>
