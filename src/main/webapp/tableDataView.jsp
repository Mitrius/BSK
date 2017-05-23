<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <META http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Tables overview</title>

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
    <c:choose>
        <c:when test="${not empty possibleTables}">
            <div class="input-group">
                <div class="input-group-btn text-center">
                    <form action="<c:url value="/getSpecificTable"/>" method="get">
                    <c:forEach var="table" items="${possibleTables}">
                        <button type="submit" name="tableName" class="btn btn-default" value="${table}">${table}</button>
                    </c:forEach>
                    </form>
                </div>
            </div>
        </c:when>
    </c:choose>
    <c:choose>
        <c:when test="${not empty table}">
            <table class="table">
                <thead>
                <tr>
                    <c:forTokens items="${entityHeader}" delims=";" var="headerCell">
                        <th>
                            <c:out value="${headerCell}"/>
                        </th>
                    </c:forTokens>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="tableRow" items="${table}">
                    <form id="delete${tableRow.split(";")[0]}" action="<c:url value="/delete"/>" method="post"></form>
                    <form id="edit${tableRow.split(";")[0]}" action="<c:url value="/editEntity"/>" method="post"></form>
                    <tr>
                        <c:forTokens var="tableCell" items="${tableRow}" delims=";">
                            <td>
                                <c:out value="${tableCell}"/>
                            </td>
                        </c:forTokens>
                        <td>
                            <c:choose>
                            <c:when test="${editPerm}">
                            <input form="edit${tableRow.split(";")[0]}" type="hidden" name="id"
                                   value="${tableRow.split(";")[0]}"/>
                            <input form="edit${tableRow.split(";")[0]}" type="hidden" name="type" value="${type}"/>
                            <input form="edit${tableRow.split(";")[0]}" type="hidden" name="entityHeader"
                                   value="${entityHeader}"/>
                            <input form="edit${tableRow.split(";")[0]}" type="hidden" name="${_csrf.parameterName}"
                                   value="${_csrf.token}"/>
                            <button class="btn btn-default" form="edit${tableRow.split(";")[0]}" type="submit">Edit
                            </button>
                            <input form="delete${tableRow.split(";")[0]}" type="hidden" name="key"
                                   value="${tableRow.split(";")[0]}"/>
                            <input form="delete${tableRow.split(";")[0]}" type="hidden" name="tableName"
                                   value="${type}"/>
                            <input form="delete${tableRow.split(";")[0]}" type="hidden" name="${_csrf.parameterName}"
                                   value="${_csrf.token}"/>
                            <button class="btn btn-default" form="delete${tableRow.split(";")[0]}" type="submit">
                                Delete
                            </button>
                            </c:when>
                            <c:otherwise>
                                <button class="btn btn-default disabled">Edit</button>
                                <button class="btn btn-default disabled">Delete</button>
                            </c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                </c:forEach>
                <c:choose>
                    <c:when test="${type != 'User'}">
                        <form id="create" action="/createNewClass/${type}" method="post"></form>
                        <tr>
                            <c:forTokens items="${entityHeader}" delims=";" var="headerCell">
                                <td>
                                    <c:if test="${headerCell ne 'id'}">
                                        <input form="create" type="text" name="${headerCell}" value=""/>
                                    </c:if>
                                </td>
                            </c:forTokens>
                            <td>
                                <input form="create" type="hidden" name="${_csrf.parameterName}"
                                       value="${_csrf.token}"/>
                                <c:choose>
                                    <c:when test="${editPerm}">
                                        <button form="create" class="btn btn-default" type="submit">Add</button>
                                    </c:when>
                                    <c:otherwise>
                                        <button class="btn btn-default disabled" type="button">Add</button>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                    </c:when>
                    <c:otherwise>
                        <form id="create" action="/createUser" method="post">
                            <c:choose>
                                <c:when test="${editPerm}">
                                    <button form="create" class="btn btn-default" type="submit">Add</button>
                                </c:when>
                                <c:otherwise>
                                    <button class="btn btn-default disabled" type="button">Add</button>
                                </c:otherwise>
                            </c:choose>
                        </form>
                    </c:otherwise>
                </c:choose>
                </tbody>
            </table>
        </c:when>
        <c:otherwise>
            <c:choose>
                <c:when test="${not empty entityHeader}">
                    <form action="/createNewClass/${type}" method="post">
                        <table class="table">
                            <thead>
                            <tr>
                                <c:forTokens items="${entityHeader}" delims=";" var="headerCell">
                                    <td>
                                        <c:out value="${headerCell}"/>
                                    </td>
                                </c:forTokens>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <c:forTokens items="${entityHeader}" delims=";" var="headerCell">
                                    <td>
                                        <c:if test="${headerCell ne 'id'}">
                                            <input type="text" name="${headerCell}" value=""/>
                                        </c:if>
                                    </td>
                                </c:forTokens>
                                <td>
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                    <button class="btn btn-default" type="submit">Add</button>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </form>
                </c:when>
            </c:choose>
        </c:otherwise>
    </c:choose>
</div>
<!-- Bootstrap core JavaScript
    ================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
<script src="<c:url value="static/js/bootstrap.min.js"/>"></script>
</body>
</html>
