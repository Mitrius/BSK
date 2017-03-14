<%--
  Created by IntelliJ IDEA.
  User: Mitrius
  Date: 13.03.17
  Time: 13:38
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/tableViewStyle.css"/>
</head>
<body>
<div id="userInfo">
    <p>Zalogowano jako użytkownik ${user}</p>
</div>
<div id="magicButton">
    <form action="${pageContext.request.contextPath}/getPossibleTables">
        <input type="submit" value="wyświetl tabele">
    </form>
</div>
<div id="tables">

    <c:choose>
        <c:when test="${not empty tables}">
            <c:forEach var="table" items="${tables}">
                <table class="dynamicTable" style="border: darkblue">
                    <c:forEach var="row" items="${table}">
                        <tr>
                            <c:forTokens var="column" items="${row}" delims=",">
                                <td>
                                    <c:out value="${column}">
                                    </c:out>
                                </td>
                            </c:forTokens>
                        </tr>
                    </c:forEach>
                </table>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <c:out value="aaa nie działam">
            </c:out>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>
