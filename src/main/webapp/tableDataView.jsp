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
        <c:choose>
            <c:when test="${not empty possibleTables}">
                <input type="submit" value="odśwież tabele"/>
            </c:when>
            <c:otherwise>
                <input type="submit" value="Wyświetl tabele">
            </c:otherwise>
        </c:choose>
    </form>
</div>
<div id="tables">
    <div id="availableTables">
        <c:choose>
            <c:when test="${not empty possibleTables}">
                <form action="<c:url value="/getSpecificTable"/>" method="get">
                    <table>
                        <tr>
                            <c:forEach var="table" items="${possibleTables}">
                                <td><input name="tableName" type="submit" value="${table}"></td>
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
                        <tr>
                            <c:forTokens items="${entityHeader}" delims="," var="headerCell">
                                <td>
                                    <c:out value="${headerCell}"/>
                                </td>
                            </c:forTokens>
                        </tr>
                        <c:forEach var="tableRow" items="${table}">
                            <form action="/delete" method="post">
                            <tr>
                                <c:forTokens var="tableCell" items="${tableRow}" delims=",">
                                    <td>
                                        <c:out value="${tableCell}"/>
                                    </td>
                                </c:forTokens>
                                <td>
                                    <input type="hidden" name="key" value="${tableRow.split(",")[0]}"/>
                                    <input type="hidden" name="tableName" value="${type}"/>
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                    <input type="submit" value="DeleteMe"/>
                                </td>
                            </tr>
                            </form>
                        </c:forEach>
                        <form id="create" action="/createNewClass/${type}" method="post">
                        <tr>
                            <c:forTokens items="${entityHeader}" delims="," var="headerCell">
                                <td>
                                    <input type="text" name="${headerCell}" value=""/>
                                </td>
                            </c:forTokens>
                        </tr>
                        </form>
                    </table>
                    <input form="create" type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <input form="create" type="submit" value="dodaj">
            </c:when>
            <c:otherwise>
                <c:choose>
                    <c:when test="${not empty entityHeader}">
                        <form action="/createNewClass/${type}" method="post">
                            <table>
                                <tr>
                                    <c:forTokens items="${entityHeader}" delims="," var="headerCell">
                                        <td>
                                            <c:out value="${headerCell}"/>
                                        </td>
                                    </c:forTokens>
                                </tr>
                                <tr>
                                    <c:forTokens items="${entityHeader}" delims="," var="headerCell">
                                        <td>
                                            <input type="text" name="${headerCell}" value=""/>
                                        </td>
                                    </c:forTokens>
                                </tr>
                            </table>
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            <input type="submit" value="dodaj"/>
                        </form>
                    </c:when>
                </c:choose>
            </c:otherwise>
        </c:choose>
    </div>
</div>
</body>
</html>
