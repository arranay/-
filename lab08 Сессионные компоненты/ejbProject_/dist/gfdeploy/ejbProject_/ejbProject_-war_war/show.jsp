<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3> Логины добавленных пользователей:&nbsp; 
        <c:forEach items="${userList}" var="user">
                 ${user}&nbsp;
        </c:forEach>
        </h3>      
    </body>
</html>
