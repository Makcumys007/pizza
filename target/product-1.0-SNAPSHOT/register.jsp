
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация</title>
</head>
<body>
<form action="/pizza/controller" method="post">
    <p>Имя:</p>
    <input type="text" name="name">
    <p>Фамилия:</p>
    <input type="text" name="lastName">
    <br>
    <input type="submit" value="Отправить">
</form>
</body>
</html>
