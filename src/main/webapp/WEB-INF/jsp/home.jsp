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


    <jsp:include  page="${pageContext.request.contextPath}/jspf/header.jsp" />

    <main class="content">
        <br>
        <div class="product_bloc">
            <h1 class="h1_title">Пицца:</h1>
            <br>
            <c:forEach var="pizza" items="${pizzas}" end="3">
                <div class="product">
                    <img width="230" height="230" src="${pizza.img}">
                    <h2>Пицца "${pizza.title}"</h2>
                    <p class="price">Цена: ${pizza.price0} тг</p>
                    <p class="desc"><span>*** </span>Состав<span> ***</span></p>
                    <p class="desc2">${pizza.description}</p>
                    <form action="/do/basket" method="POST">
                        <input type="hidden" name="id" value="${pizza.id}">
                        <input type="submit" value="В корзину">
                    </form>
                </div>
            </c:forEach>
        </div>

        <div class="product_bloc">
            <h1 class="h1_title">Суши:</h1>
            <br>

            <c:forEach var="sushi" items="${sushis}" end="3">
                <div class="product">
                    <img width="218" height="218" src="${sushi.img}">
                    <h2>Суши "${sushi.title}"</h2>
                    <p class="price">Цена: ${sushi.price0} тг</p>
                    <p class="desc"><span>*** </span>Состав<span> ***</span></p>
                    <p class="desc2">${sushi.description}</p>
                    <form action="/do/basket" method="POST">
                        <input type="hidden" name="id" value="${sushi.id}">
                        <input type="submit" value="В корзину">
                    </form>
                </div>
            </c:forEach>
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