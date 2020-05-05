<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Редактировать</title>
        <style>
            
        </style>
    </head>
    <body>
            <form action="editUser" method="post">
                <input type="hidden" name="id" value="${user.id}">
                <table>
                <tr> <td>текущий логин - ${user.login}</td>
                    <td><input required type="text" name="login" /></td>
                </tr>
                <tr><td>текущая роль - ${user.role.name}</td>
                <td><select name="role">
                    <c:forEach items="${roleList}" var="role">
                      <option value="${role.id}">${role.name}</option>
                    </c:forEach>
                   </select></td>
                </tr>
                <tr> 
                    <td colspan="2"><input type="submit" value="сохранить"></td>
                </tr></table>
            </form>
    </body>
</html>