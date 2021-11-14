<%--
  Created by IntelliJ IDEA.
  User: TechCare
  Date: 11/13/2021
  Time: 6:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sandwich Condiments</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<form action="/save" method="post">
    <input type="checkbox" name="condiment" id="Lettuce" value="Lettuce">
    <label for="Lettuce">Lettuce</label>
    <input type="checkbox" name="condiment" id="Tomato" value="Tomato">
    <label for="Tomato">Tomato</label>
    <input type="checkbox" name="condiment" id="Mustard" value="Mustard">
    <label for="Mustard">Mustard</label>
    <input type="checkbox" name="condiment" id="Sprouts" value="Sprouts">
    <label for="Sprouts">Sprouts</label>
    <button type="submit">Save</button>
</form>
<p>
    Sandwich
    <c:forEach items="${condiment}" var="condiment">
        ${condiment}
    </c:forEach>
</p>


</body>
</html>
