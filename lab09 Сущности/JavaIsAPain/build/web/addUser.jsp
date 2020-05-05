<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Создание нового пользователя</title>
        <style>
            .error{
                color: red;
            }
        </style>
    </head>
    <body>
    <form action="addUser" method="post">
            <table>
            <tr>
                <td>Логин</td>
                <td><input required type="text" name="login" /></td>
            </tr>
            <tr>
                <td>Пароль</td>
                <td><input required type="password" name="password"  /></td>
            </tr>
            <tr>
                <td>Повторите пароль</td>
                <td><input required type="password" name="password2"  /></td>
            </tr>
            <tr>
                <td>Роль</td>
                <td><select name="role">
                    <c:forEach items="${roleList}" var="role">
                      <option value="${role.id}">${role.name}</option>
                    </c:forEach>
                   </select></td>
            </tr>
                
            <tr>
                <td>
                    <input required type="submit" value="Сохранить"/>
                </td></tr>
            </table>   
    </form>
        <h3 class="error">${error}</h3>
    </body>
</html>