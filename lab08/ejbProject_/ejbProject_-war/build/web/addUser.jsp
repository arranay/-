<%-- 
    Document   : addUser
    Created on : 12.03.2020, 17:57:52
    Author     : Лера
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Создание нового пользователя</title>
    </head>
    <body>
    <form action="addUser" method="post">
            <table>
            <tr>
                <td>Логин</td>
                <td><input required type="text" name="login" /></td>
            </tr>
            <tr>
                <td>Email</td>
                <td><input required type="text" name="email" /></td>
            </tr>
            <tr>
                <td>Дата рождения</td>
                <td><input required type="text" name="bdate" /></td>
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
                <td><input required type="submit" value="Сохранить"/></td></tr>
            </table>
    </form>
    </body>
</html>
