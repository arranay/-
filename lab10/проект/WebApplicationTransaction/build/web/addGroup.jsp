<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Добавить группу</title>

    </head>
    <body>
    <form action="addGroup" method="post">
            <table>
            <tr>
                <td>Название</td>
                <td><input required type="text" name="name" /></td>
            </tr>
            <tr>
                <td>Описание</td>
                <td><input required type="text" name="description"  /></td>
            </tr>
            <tr>
                <td>Кол-во студентов</td>
                <td><input required type="text" name="number"  /></td>
            </tr>
                
            <tr>
                <td>
                    <input required type="submit" value="Сохранить"/>
                </td></tr>
            </table>   
    </form>
    </body>
</html>