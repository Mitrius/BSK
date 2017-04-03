<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Remote Mac interface</title>
    <link rel="stylesheet" href="<c:url value="static/tableViewStyle.css"/> "/>
</head>
<body>
<div id="logDiv">
    <h3 style="text-align: center">Logowanie</h3>
    <form id="loginForm" method="post" action="${pageContext.request.contextPath}/userLogin">
        <label>
            Login użytkownika:
            <input type="text" name="userLogin">
        </label>
        <label>
            Hasło:
            <input type="password" name="userPassword">
        </label>
        <br>
        <input type="submit" value="zaloguj ">
    </form>
</div>
</body>
</html>
