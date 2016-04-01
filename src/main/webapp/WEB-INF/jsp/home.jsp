<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="h" %>
<%@ taglib prefix="mtf" uri="http://java.sun.com/jsp/jstl/fmt" %>

<mtf:setLocale value="${locale}" scope="session"/>

<mtf:bundle basename="header_footer">
    <mtf:message key="home" var="home_title" />
    <mtf:message key="pizza" var="pizza_title" />
    <mtf:message key="sushi" var="sushi_title" />
    <mtf:message key="drinks" var="drinks_title" />
    <mtf:message key="contacts" var="contacts_title" />
    <mtf:message key="basket" var="basket_title" />

    <mtf:message key="slogan_header_1" var="sloganHeader1" />
    <mtf:message key="slogan_header_2" var="sloganHeader2" />

    <mtf:message key="login" var="login_title" />
    <mtf:message key="password" var="password_title" />
    <mtf:message key="enter" var="enter_title" />
    <mtf:message key="check_in" var="check_in_title" />

    <mtf:message key="price" var="price_title" />
    <mtf:message key="add_cart" var="add_cart_title" />
    <mtf:message key="composition" var="composition_title" />

    <mtf:message key="slogan_footer" var="sloganFooter" />
    <mtf:message key="marka" var="marka_title" />
    <mtf:message key="login_in" var="login_in" />

    <mtf:message key="register_validate" var="registerValidate" />
</mtf:bundle>

<h:head  title="${home_title}"/>

<header class="header">
    <div class="logo"></div>
    <div class="slogan"><p class="slogan2">${sloganHeader1}</p>
        <p class="slogan3">${sloganHeader2}</p></div>
    <div class="login">
        <form action="login" method="POST">
            <c:if test="${welcome}" >
                <p class="validate_r">${login_in}</p>
            </c:if>
            <c:if test="${validate}" >
                <p class="validate_r">${registerValidate}</p>
            </c:if>
            <p class="login_p">${login_title}:</p>
            <input type="text" name="login" />
            <p class="login_p">${password_title}:</p>
            <input type="password" name="password" />
            <br/>
            <p class="login_p"><input type="submit" value="${enter_title}" /> <a href="${pageContext.request.contextPath}/do/register">${check_in_title}</a></p>
        </form>
        <h:locale />
    </div>
    <div class="nav">
        <ul>
            <li><a href="${pageContext.request.contextPath}/do/">${home_title}</a></li>
            <li><a href="${pageContext.request.contextPath}/do/product?type=pizza">${pizza_title}</a></li>
            <li><a href="${pageContext.request.contextPath}/do/product?type=sushi">${sushi_title}</a></li>
            <li><a href="${pageContext.request.contextPath}/do/product?type=drink">${drinks_title}</a></li>
            <li><a href="${pageContext.request.contextPath}/do/contacts">${contacts_title}</a></li>
            <li><a href="#">${basket_title}(0)</a></li>
        </ul>
    </div>

</header><!-- .header-->

    <main class="content">
        <br>
        <div class="product_bloc">
            <h1 class="h1_title">${pizza_title}:</h1>
            <br>
            <c:forEach var="pizza" items="${pizzas}" end="3">
                <div class="product">
                    <img width="230" height="230" src="${pizza.img}">
                    <h2>${pizza_title} "${pizza.title}"</h2>
                    <p class="price">${price_title}: ${pizza.price0} тг</p>
                    <p class="desc"><span>*** </span>${composition_title}<span> ***</span></p>
                    <p class="desc2">${pizza.description}</p>
                    <form action="/do/basket" method="POST">
                        <input type="hidden" name="id" value="${pizza.id}">
                        <input type="submit" value="${add_cart_title}">
                    </form>
                </div>
            </c:forEach>
        </div>

        <div class="product_bloc">
            <h1 class="h1_title">${sushi_title}:</h1>
            <br>

            <c:forEach var="sushi" items="${sushis}" end="3">
                <div class="product">
                    <img width="218" height="218" src="${sushi.img}">
                    <h2>${sushi_title} "${sushi.title}"</h2>
                    <p class="price">${price_title}: ${sushi.price0} тг</p>
                    <p class="desc"><span>*** </span>${composition_title}<span> ***</span></p>
                    <p class="desc2">${sushi.description}</p>
                    <form action="/do/basket" method="POST">
                        <input type="hidden" name="id" value="${sushi.id}">
                        <input type="submit" value="${add_cart_title}">
                    </form>
                </div>
            </c:forEach>
        </div>

<h:footer company="${marka_title}" slogan="${sloganFooter}" />

