<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <META http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>User registration</title>
    <!-- Bootstrap core CSS -->
    <link href="<c:url value="static/css/bootstrap.min.css"/>" rel="stylesheet">
    <!-- Bootstrap theme -->
    <link href="<c:url value="static/css/bootstrap-theme.min.css"/>" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">BSK</a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <c:choose>
                <c:when test="${not empty possibleTables}">
                <li class="active">
                    </c:when>
                    <c:otherwise>
                <li>
                    </c:otherwise>
                    </c:choose>
                    <a href="<c:url value="/getTableNames"/>">Tables<span class="sr-only">(current)</span></a></li>
                <c:choose>
                    <c:when test="${not empty table}">
                        <li class="active"><a href="#">${type}s</a></li>
                    </c:when>
                </c:choose>
            </ul>
            <form class="navbar-form navbar-left" action="<c:url value="/logout"/>">
                <button type="submit" class="btn btn-default">Logout</button>
            </form>
        </div>
    </div>
</nav>
<div class="container">
    <form action="<c:url value="/createNewClass/User"/>" method="post">
        <label>Login użytkownika
            <input type="text" name="username">
        </label>
        <br>
        <label>Hasło
            <input type="password" name="password">
        </label>
        <br>
        <input type="hidden" value="USER" name="role">
        <label>Dopuszczony
            <input id="checkbox1" type="checkbox" value="true" name="enabled">
        </label>
        <br>
        <label>Poziom dopuszczenia
            <input list="levels" name="clearanceLevel">
        </label>
        <datalist id="levels">
            <option value="0">Publiczny</option>
            <option value="1">Poufny</option>
            <option value="2">Tajny</option>
            <option value="3">Ściśle tajny</option>
        </datalist>
        <input type="hidden" name="${_csrf.parameterName}"
               value="${_csrf.token}"/>
        <br>
        <input type="submit" value="Stwórz użytkownika">
    </form>
</div>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script>
    $("#checkbox1").on('change', function () {
        if ($(this).is(':checked')) {
            $(this).attr('value', 'true');
        } else {
            $(this).attr('value', 'false');
        }
    });
</script>
</html>
