<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Table edit</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="static/css/bootstrap.min.css"/>" rel="stylesheet">
    <!-- Bootstrap theme -->
    <link href="<c:url value="static/css/bootstrap-theme.min.css"/>" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">BSK</a>
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="<c:url value="/getTableNames"/>">Tables<span class="sr-only">(current)</span></a></li>
                <li><a href="<c:url value="/getSpecificTable"/>?tableName=${type}s">${type}s</a></li>
                <li class="active"><a href="#">Edit</a></li>
            </ul>
            <form class="navbar-form navbar-left" action="<c:url value="/logout"/>">
                <button type="submit" class="btn btn-default">Logout</button>
            </form>
        </div>
    </div>
</nav>
<div class="container">
    <form action="/editEntity/${type}" method="post">
        <table class="table">
            <thead>
            <tr>
                <c:forEach items="${entityHeader}" var="headerCell" varStatus="status">
                    <td>
                        <c:out value="${headerCell}"/>
                    </td>
                </c:forEach>
            </tr>
            </thead>
            <tbody>
            <tr>
                <c:forEach items="${entityHeader}" var="headerCell" varStatus="status">
                    <td>
                        <c:if test="${headerCell ne 'id'}">
                        <input type="text" value="${entity[status.index]}" name="${headerCell}"/>
                        </c:if>
                    </td>
                </c:forEach>
                <td>
                    <input type="hidden" name="key" value="${entity[0]}"/>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <button class="btn btn-default" type="submit">Update</button>
                </td>
            </tr>
            </tbody>
        </table>
    </form>
</div>
</body>
</html>
