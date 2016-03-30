<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <!--[if lt IE 9]><script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
    <title>Контакты</title>
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">

</head>

<body>

<div class="wrapper">

            <jsp:include  page="${pageContext.request.contextPath}/jspf/header.jsp" />


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