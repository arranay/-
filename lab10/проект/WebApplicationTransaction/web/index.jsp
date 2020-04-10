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
        <form action = "groupList" method="get">
            <input type="submit" value="Список всех групп">
        </form><br>
        <form action = "addGroup" method="get">
            <input type="submit" value="Добавить группу">
        </form><br>
        
        Транзакции:
        <form action = "transactionControllers" method="post">
            <input type="submit" value="Выполнить транзакцию">
        </form><br>
    </body>
</html>
