<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <form action = "userList" method="get">
            <input type="submit" value="Список пользователей">
        </form><br>
         <form action = "addUser" method="get">
            <input type="submit" value="Добавить пользователя">
        </form><br>
        <form action = "roleList" method="get">
            <input type="submit" value="Список всех ролей">
        </form><br>
        <form action = "allStudents" method="get">
            <input type="submit" value="Показать только студентов">
        </form><br>
    </body>
</html>
