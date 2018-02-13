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

    <br>Название игры: <input name="name" type="text" value="${requestScope.name}"/>
    <br>Язык игры: <input list="language" name="language" value="${requestScope.language}" aria-dropeffect="popup"/>
    <datalist id="language">
        <option>RUSSIAN</option>
        <option>ENGLISH </option>
        <option>GERMAN</option>
        <option>FRENCH</option>
    </datalist>
    <br>Возрастное ограничение: <input type="number" min="0" max="21" value="${requestScope.age}" step="1" name="ageRestrictions">
    <br>Стоимость: <input type="number" min="0" value="${requestScope.cost}" name="cost" step = "1">


    <br>
    Количество записей:    <input name="numberOfRows"  type="number" min="5" max="50" step="5" value="${requestScope.currentNumberOfRows}">
    <c:if test="${requestScope.currentPage > 1}">
        <button type="submit" name = "nextPage"  value="${currentPage-1}">${requestScope.get("currentPage")-1}</button>
    </c:if>
    <button type="submit" name = "nextPage" value="${currentPage}"aria-current="date">${requestScope.get("currentPage")}</button>
    <button type="submit" name = "nextPage" value="${currentPage+1}">${requestScope.get("currentPage")+1}</button>
    <button type="submit" name = "nextPage" value="${currentPage+2}">${requestScope.get("currentPage")+2}</button>
    <button type="submit" name = "nextPage" value="${currentPage+3}">${requestScope.get("currentPage")+3}</button>
    <button type="submit" name = "nextPage" value="${currentPage+4}">${requestScope.get("currentPage")+4}</button>

</form>
<c:forEach items="${requestScope.allGames}" var="game">
    <br><c:out value="${game}"/>
</c:forEach>
</body>
</html>
