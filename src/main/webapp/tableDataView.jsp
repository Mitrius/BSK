<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Podgląd tabeli</title>
    <link rel="stylesheet" href="<c:url value="static/Style.css"/> "/>
</head>
<body>
<div id="userInfo">
    <p>Zalogowano jako użytkownik</p>
    <p>Stopień uprawnień: 4</p>
    <form action="${pageContext.request.contextPath}/logout" id="submitButt">
        <input type="submit" value="wyloguj">
    </form>
    <a href="${pageContext.request.contextPath}/register">Rejestracja</a>
</div>
<div id="magicButton">
    <form action="${pageContext.request.contextPath}/getPossibleTables">
        <c:choose>
            <c:when test="${not empty possibleTables}">
                <input type="submit" value="odśwież tabele">
            </c:when>
            <c:otherwise>
                <input type="submit" value="wyświetl tabele">
            </c:otherwise>
        </c:choose>
    </form>
</div>
<div id="tables">
    <div id="availableTables">
        <c:choose>
            <c:when test="${not empty possibleTables}">
                <form action="${pageContext.request.contextPath}/getSpecificTable">
                    <table>
                        <tr>
                            <c:forEach var="table" items="${possibleTables}">
                                <td><input type="submit" value="${table}" name="tableName"></td>
                            </c:forEach>
                        </tr>
                    </table>
                </form>
            </c:when>
        </c:choose>
    </div>
    <div id="detailedTableView">
        <c:choose>
            <c:when test="${not empty table}">
                <table>
                    <c:forEach var="tableRow" items="${table}">
                        <tr>
                            <c:forTokens var="tableCell" items="${tableRow}" delims=",">
                                <td>
                                    <c:out value="${tableCell}"/>
                                </td>
                            </c:forTokens>
                        </tr>
                    </c:forEach>
                </table>
            </c:when>
        </c:choose>
    </div>
</div>
</body>
</html>
