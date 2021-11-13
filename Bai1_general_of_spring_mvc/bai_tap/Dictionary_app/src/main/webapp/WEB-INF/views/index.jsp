<%--
  Created by IntelliJ IDEA.
  User: TechCare
  Date: 11/12/2021
  Time: 10:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h1>Translate app</h1>
<form method="post" action="/translate">
    <label for="eng">English: </label>
    <input type="text" name="eng" id="eng">
    <button type="submit">Translate</button>
</form>
<p>Vietnamese: ${vie}</p>
</body>
</html>
