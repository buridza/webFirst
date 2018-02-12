<%--
  Created by IntelliJ IDEA.
  User: Denis
  Date: 1/20/2018
  Time: 11:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:set var="currentPage" scope="session" value="1"/>
<form action="/pagination" method="get">

        Количество записей:    <input name="numberOfRows"  type="number" min="5" max="50" step="5" value="5">
    <c:if test="${requestScope.currentPage > 1}">
        <button type="submit" name = "nextPage"  value="${currentPage-1}">${requestScope.get("currentPage")-1}</button>
    </c:if>
    <button type="submit" name = "nextPage" value="${currentPage}" disabled>${requestScope.get("currentPage")}</button>
    <button type="submit" name = "nextPage" value="${currentPage+1}">${requestScope.get("currentPage")+1}</button>
    <button type="submit" name = "nextPage" value="${currentPage+2}">${requestScope.get("currentPage")+2}</button>
    <button type="submit" name = "nextPage" value="${currentPage+3}">${requestScope.get("currentPage")+3}</button>
    <button type="submit" name = "nextPage" value="${currentPage+4}">${requestScope.get("currentPage")+4}</button>

    <c:forEach items="${requestScope.allGames}" var="game">
    <br><c:out value="${game}"/>
    </c:forEach>
</form>
</body>
</html>
