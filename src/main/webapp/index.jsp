
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="register.jsp">Регистрация</a>
<form action="/pizza/controller" method="POST">
    <p>Логин:</p>
    <input type="text" name="login" />
    <p>Пароль: </p>
    <input type="text" name="password"/>
    <br/> <input type="submit" value="Войти"/>
</form>
</body>
</html>
