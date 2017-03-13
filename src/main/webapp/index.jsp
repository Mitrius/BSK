<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>super fajna apka BSK</title>
</head>
<body>
<div id="logDiv">
    <form id="loginForm" method="post" action="${pageContext.request.contextPath}/login">
        <label>
            Login użytkownika:
            <input type="text" name="userLogin">
        </label>
        <label>
            Hasło:
            <input type="password" name="userPassword">
        </label>
        <input type="submit">
    </form>
</div>
</body>
</html>
