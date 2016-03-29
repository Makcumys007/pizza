<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <!--[if lt IE 9]><script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
    <title>Главная</title>
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">

</head>

<body>

<div class="wrapper">

    <header class="header">
        <div class="logo"></div>
        <div class="slogan"><p class="slogan2">Свежая, вкусная, горячая пица... </p>
            <p class="slogan3">Бесплатная доставка, <br>тел. <span>+7(888)</span> 88-88-888 <br>тел. <span>+7(888)</span> 88-88-888 <br>всегда вкусно и быстро...</p></div>
        <div class="login">
            <form action="login" method="POST">
                <p class="login_p">Логин:</p>
                <input type="text" name="login" />
                <p class="login_p">Пароль:</p>
                <input type="password" name="password" />
                <br/>
                <p class="login_p"><input type="submit" value="Войти" /> <a href="#">Регистрация</a></p>
            </form>
        </div>

        <div class="nav">
            <ul>
                <li><a href="${pageContext.request.contextPath}/do/">Главная</a></li>
                <li><a href="#">Пицца</a></li>
                <li><a href="#">Суши</a></li>
                <li><a href="#">Напитки</a></li>
                <li><a href="#">Контакты</a></li>
                <li><a href="#">Корзина(0)</a></li>
            </ul>
        </div>
    </header><!-- .header-->

    <main class="content">
        <h1 class="h1_title">Пицца:</h1>
        <br>

        <div class="product">
            <img src="img_tmp/pepperoni__small.png">
            <h2>Пицца "Пеперони"</h2>
            <p class="price">Цена: 1200 тг</p>
            <p class="desc"><span>*** </span>Состав<span> ***</span></p>
            <p class="desc2">Салями, болгарский перец, сыр Моцарелла, пицца-соус, маслины...</p>
            <form>
                <input type="submit" value="В корзину">
            </form>
        </div>
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