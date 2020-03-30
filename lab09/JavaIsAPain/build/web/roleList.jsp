<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Список ролей</title>
        
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
        <td></td>
        <td></td>
    </tr>
    <c:forEach items="${roleList}" var="role">
                 <tr>
                    <td>${role.getName()}</td>
                    <td>${role.getDescription()}</td>
                    <td>
                </tr>
        </c:forEach>
        </table>
    </body>
</html>