<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Список пользователей</title>
        
        <style>
            table{
                border-spacing:0;
                width: 80%;
                height: 100%;
                font-size: 20px;
            }
            
            .btn{
                background: none;
                color: black;
                border: 0;
                font-size: 20px;
            }
        </style>
    </head>
    <body>
        
        <table align="center">
    <tr>
        <td>логин</td>
        <td>пароль</td>
        <td>email</td>
        <td>дата рождения</td>
        <td>роль в системе</td>
        <td></td>
        <td></td>
    </tr>
    <c:forEach items="${userList}" var="user">
                 <tr>
                    <td>${user.getLogin()}</td>
                    <td>${user.getPassword()}</td>
                    <td>${user.getRole().getName()}</td>
                    <td>
                    <form action="userEdit" method="get">
                        <input type="hidden" name="id" value="${user.getId()}">
                        <input class="btn" type="submit" value="редактировать">                     
                    </form>
                </td>
                <td><form action="user" method="post">
                    <input type="hidden" name="id" value="${user.getId()}">
                    <input class="btn" type="submit" value="удалить">
                </form>
                </td>
                </tr>
        </c:forEach>
        </table>
    </body>
</html>