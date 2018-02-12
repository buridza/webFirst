<%--
  Created by IntelliJ IDEA.
  User: Denis
  Date: 2/11/2018
  Time: 9:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test Filter</title>
</head>
<body>
filter
<input list="Entity" name="Entity" >
<datalist id="Entity">
    <option id="user">User</option>
    <option id="game">Game</option>
</datalist>
<form action="/pagination" method="get">

    <input name="name" type="text"/>
    <input list="${requestScope.language}" name="language"/>
    <c:if test="${pageScope.Entity == user}">
     Возраст пользователя:   <input type="text" name = "age"/>
    </c:if>
    <c:if test="${pageScope.Entity == Game}">
     Возрастное ограничение:   <input type="text" name = "age"/>
    </c:if>
</form>

</body>
</html>
