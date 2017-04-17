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
        <c:otherwise>
            <input type="submit" value="Wyświetl tabele">
        </c:otherwise>
    </form>
</div>
<div id="tables">
    <div id="tableEditDiv">
        <form>
            <table>
                <tr>
                    <c:forTokens var="headerCell" items="${entityHeader}" delims=",">
                        <td>
                            <c:out value="${headerCell}"/>
                        </td>
                    </c:forTokens>
                    <c:forEach items="${entityHeader}" var="headerCell" varStatus="status">
                        <td>
                            <input type="text" value="${entity[status.index]} name="${headerCell}"/>
                        </td>
                    </c:forEach>
                </tr>
            </table>
        </form>

    </div>
</div>
</body>
</html>
