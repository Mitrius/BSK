<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Remote Mac interface</title>
    <link rel="stylesheet" href="<c:url value="static/Style.css"/> "/>
</head>
<body>
<div id="logDiv">
    <h3 style="text-align: center">Logowanie</h3>
    <form id="loginForm" method="post" action="${pageContext.request.contextPath}/login">
        <label>
            Login użytkownika:
            <input type="text" name="username">
        </label>
        <label>
            Hasło:
            <input type="password" name="password">
        </label>
        <br>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input name="submit" type="submit" value="zaloguj ">
    </form>
</div>
</body>
</html>
