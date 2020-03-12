<%-- 
    Document   : userUpdate
    Created on : 11.03.2020, 21:41:12
    Author     : Лера
--%>

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
            <form action="userEdit" method="post">
                <input type="hidden" name="id" value="${user.getUserID()}">
                <table>
                <tr> <td>${user.getLogin()}</td>
                    <td><input required type="text" name="newLogin" /></td>
                </tr>
                <tr> <td>${user.getEmail()}</td>
                    <td><input required type="text" name="newEmail" /></td>
                </tr>
                <tr> <td>Введите старый пароль</td>
                    <td><input required type="password" name="pass1" /></td>
                </tr>
                <tr> <td>Введите новый пароль</td>
                    <td><input required type="password" name="newPass" /></td>
                </tr>
                <tr><td>Повторите пароль</td>
                    <td><input required type="password" name="newPass2" /></td>
                </tr>
                <tr> <td colspan="2"><input type="submit" value="сохранить"></td>
                </tr></table>
            </form>
    </body>
</html>
