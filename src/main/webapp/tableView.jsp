<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Podgląd tabeli</title>
    <link rel="stylesheet" href="<c:url value="static/tableViewStyle.css"/> "/>
</head>
<body>
<div id="userInfo">
    <p>Zalogowano jako użytkownik ${user}</p>
    <p>Stopień uprawnień: 4</p>
    <form action="${pageContext.request.contextPath}/logout" id="submitButt">
        <input type="submit" value="wyloguj">
    </form>
</div>
<div id="magicButton">
    <form action="${pageContext.request.contextPath}/getPossibleTables">
        <c:choose>
            <c:when test="${not empty tables}">
                <input type="submit" value="odśwież tabele">
            </c:when>
            <c:otherwise>
                <input type="submit" value="wyświetl tabele">
            </c:otherwise>
        </c:choose>
    </form>
</div>
<div id="tables">
    <c:choose>
        <c:when test="${not empty tables}">
            <c:forEach var="table" items="${tables}">
                <form>
                    <table class="dynamicTable">
                        <c:forEach var="row" items="${table}" varStatus="rowLoopIndex">
                        <tr>
                            <c:choose>
                                <c:when test="${rowLoopIndex.index == 0}">
                                    <td>Usuń</td>
                                    <c:forTokens var="column" items="${row}" delims=",">
                                        <td>
                                            <c:out value="${column}"/>
                                        </td>
                                    </c:forTokens>
                                </c:when>
                                <c:otherwise>
                                    <td>
                                        <input type="checkbox">
                                    </td>
                                    <c:forTokens var="column" items="${row}" delims=",">
                                        <td>
                                            <input type="text" value="${column}">
                                        </td>
                                    </c:forTokens>
                                </c:otherwise>
                            </c:choose>
                        </tr>
                        </c:forEach>
                        <tr>
                            <td>
                            </td>
                            <c:forEach var="column" items="${table.get(1)}">
                                <td>
                                    <input type="text">
                                </td>
                            </c:forEach>
                        </tr>
                </table>
                    <input type="submit">
                </form>
            </c:forEach>
        </c:when>
    </c:choose>
</div>
</body>
</html>
