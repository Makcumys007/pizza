<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <!--[if lt IE 9]><script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
    <title>Регистрация</title>
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">

</head>

<body>

<div class="wrapper">

            <jsp:include  page="${pageContext.request.contextPath}/jspf/header.jsp" />


    <main class="content">
        <br>
        <h1 class="h1_title">Регистрация:</h1>
        <br>
        <form action="/do/register" method="POST">
            <p class="login_p">Логин: </p>
            <input type="text" name="login" value="" />
            <p class="login_p">Пароль: </p>
            <input type="text" name="password" value="" />
            <p class="login_p">Email: </p>
            <input type="text" name="email" value="" />
            <p class="login_p">
                <input type="submit" value="Зарегистрироваться" /></p>
        </form>
        <br>
    </main><!-- .content -->

</div><!-- .wrapper -->

<footer class="footer">
    <p class="company">© Торговая компания “Pizza House” 2014-2016</p>
    <p class="slogan4">Бесплатная доставка, тел. +7(888) 88-88-888 тел. +7(888) 88-88-888
        всегда вкусно и быстро...</p>
</footer><!-- .footer -->

</body>
</html>