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
    <title>Добавить группу</title>
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
<table>
    <form action="group" method="post">
        <input type="hidden" name="go" value="CreateGroup" />
            <tr>
                <td>Название группы</td>
                <td><input type="text" name="groupName" /></td>
            </tr>
            <tr>
                <td>Дата создания</td>
                <td><input type="text" name="creationDate"  /></td>
            </tr>
            <tr>
                <td>Имя куратора</td>
                <td><input type="text" name="curatorName"  /></td>
            </tr>
            <tr>
                <td><input type="submit" value="Принять изменения"/></td></tr>
    </form>
    <tr><td>
        <form action = "index.jsp">
            <input type="submit" value="Назад">
        </form>
    </td><td></td></tr>
</table>
</body>
</html>
