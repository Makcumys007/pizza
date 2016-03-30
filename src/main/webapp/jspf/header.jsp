<%@ page pageEncoding="UTF-8" %>
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