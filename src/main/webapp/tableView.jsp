<%--
  Created by IntelliJ IDEA.
  User: Mitrius
  Date: 13.03.17
  Time: 13:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
</head>
<body>
<div id="userInfo">
    <p>Zalogowano jako użytkownik ${user.getUserLogin()}</p>
</div>
<div id="magicButton">
    <form onsubmit="renderTables()">
        <input type="submit" value="wyświetl tabele">
    </form>
</div>
<div id="tables">
</div>
</body>
<script>
    function renderTables() {
        var tables, status;
        $.getJSON("/getPossibleTables", function (tables) {
            var tablesParsed = JSON.parse(tables);
            var working = document.createElement("p");
            working.text = tables;
            var divTab = document.getElementById("tables");
            divTab.appendChild(working);
        })
    }

</script>
</html>
