<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="h" %>

<h:head  title="Контакты"/>

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
            <p class="login_p"><input type="submit" value="Войти" /> <a href="${pageContext.request.contextPath}/do/register">Регистрация</a></p>
        </form>
    </div>
    <div class="nav">
        <ul>
            <li><a href="${pageContext.request.contextPath}/do/">Главная</a></li>
            <li><a href="${pageContext.request.contextPath}/do/product?type=pizza">Пицца</a></li>
            <li><a href="${pageContext.request.contextPath}/do/product?type=sushi">Суши</a></li>
            <li><a href="${pageContext.request.contextPath}/do/product?type=drink">Напитки</a></li>
            <li><a href="${pageContext.request.contextPath}/do/contacts">Контакты</a></li>
            <li><a href="#">Корзина(0)</a></li>
        </ul>
    </div>

</header><!-- .header-->
    <main class="content">
        <br>
        <h1 class="h1_title">Наши контакты:</h1>
        <br>
        <div class="contacts">
            <p>Республика Казахстан, Карагандинская область,<br> г. Балхаш ул. Ленина д. 60 "Pizza House"</p>
            <p>Вы можете прийти к нам в пиццерию, и отведать нашу пиццу.</p>
            <p>А так же вы можете заказать пиццу по телефону<br><span class="blue"> <span class="blue2">+7(888)</span> 88-88-888, <span class="blue2">+7(888)</span> 88-88-888</span></p>
            <p>Либо заказать онлайн на нашем сайте.</p>
            <p>Приятного вам аппетита!!!</p>
        </div>

<h:footer company="© Торговая компания “Pizza House” 2014-2016" slogan="Бесплатная доставка, тел. +7(888) 88-88-888 тел. +7(888) 88-88-888
    всегда вкусно и быстро..." />