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
    <title>Удалить группу</title>
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
Вы действительно хотите удалить группу ${param.groupName}(id=${param.id})?
<tr>
<td><form action="group" method="post">
        <input type="hidden" name="go" value="DeleteGroup" />
        <input type="hidden" name="id" value="${param.id}">
    <input type="submit" value="Удалить">
    </form>
</td>
<td>
    <form action = "index.jsp">
        <input type="submit" value="Назад">
    </form>
</td></tr>
</body>
</html>
