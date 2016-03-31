<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="h" %>
<%@ taglib prefix="mtf" uri="http://java.sun.com/jsp/jstl/fmt" %>



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

    <mtf:message key="register_validate" var="registerValidate" />


</mtf:bundle>

<h:head  title="${check_in_title}"/>

<header class="header">
    <div class="logo"></div>
    <div class="slogan"><p class="slogan2">${sloganHeader1}</p>
        <p class="slogan3">${sloganHeader2}</p></div>
    <div class="login">
        <form action="login" method="POST">
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
        <h1 class="h1_title">${check_in_title}:</h1>
        <br>

        <c:if test="${validate}" >
            <p class="validate_r">${registerValidate}</p>
        </c:if>

        <form action="/do/register" method="POST">
            <p class="login_p">${login_title}: </p>
            <input type="text" name="login" value="" />
            <p class="login_p">${password_title}: </p>
            <input type="text" name="password" value="" />
            <p class="login_p">Email: </p>
            <input type="text" name="email" value="" />
            <p class="login_p">
                <input type="submit" value="${check_in_title}" /></p>
        </form>


<h:footer company="${marka_title}" slogan="${sloganFooter}" />