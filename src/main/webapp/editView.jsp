<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Podgląd tabel</title>
    <link rel="stylesheet" href="<c:url value="static/Style.css"/> "/>
</head>
<body>
<div id="userInfo">
    <form action="<c:url value="/logout"/>" id="submitButt">
        <input type="submit" value="wyloguj">
    </form>
    <a href="<c:url value="/register"/>">Rejestracja</a>
</div>
<div id="magicButton">
    <form action="<c:url value="/getPossibleTables"/>" id="getTablesButt">
        <input type="submit" value="Wyświetl tabele">
    </form>
</div>
<div id="tables">
    <div id="tableEditDiv">
        <form action="/editEntity/${type}" method="post">
            <table>
                <tr>
                    <c:forEach items="${entityHeader}" var="headerCell" varStatus="status">
                        <td>
                            <c:out value="${headerCell}"/>
                        </td>
                    </c:forEach>
                </tr>
                <tr>
                    <c:forEach items="${entityHeader}" var="headerCell" varStatus="status">
                        <td>
                            <input type="text" value="${entity[status.index]}" name="${headerCell}"/>
                        </td>
                    </c:forEach>
                </tr>
            </table>
            <input type="hidden" name="key" value="${entity[0]}"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <input type="submit" value="Update">
        </form>

    </div>
</div>
</body>
</html>
