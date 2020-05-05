<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Список групп</title>
        
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
        <td>название</td>
        <td>описание</td>
        <td>кол-во студентов</td>
        <td></td>
    </tr>
    <c:forEach items="${groupList}" var="group">
                 <tr>
                    <td>${group.name}</td>
                    <td>${group.description}</td>
                    <td>${group.numberOfStudents}</td>
                <td><form action="groupList" method="post">
                    <input type="hidden" name="id" value="${group.id}">
                    <input class="btn" type="submit" value="удалить">
                </form>
                </td>
                </tr>
        </c:forEach>
        </table>
    </body>
</html>