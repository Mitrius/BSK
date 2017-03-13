<%--
  Created by IntelliJ IDEA.
  User: Mitrius
  Date: 13.03.17
  Time: 13:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="userInfo">
    <p>Zalogowano jako użytkownik ${user.getUserLogin()}</p>
</div>
<div id="magicButton">
    <form action="${pageContext.request.contextPath}/getPossibleTables">
        <input type="submit" value="wyświetl tabele">
    </form>
</div>
<div id="tables">
</div>
</body>
<script>
    function renderTables() {
        var tablediv = document.createElement("div");

    }
</script>
</html>
