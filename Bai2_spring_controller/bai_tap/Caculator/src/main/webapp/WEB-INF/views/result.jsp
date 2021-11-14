<%--
  Created by IntelliJ IDEA.
  User: TechCare
  Date: 11/14/2021
  Time: 1:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
<form method="post" action="/result">
    <label for="number1">Number 1:</label>
    <input type="number" name="number1" id="number1">
    <label for="number2">Number 2:</label>
    <input type="number" name="number2" id="number2">
    <button type="submit" value="addition" name="asmd">Addition</button>
    <button type="submit" value="subtraction" name="asmd">Subtraction</button>
    <button type="submit" value="multiplication" name="asmd">Multiplication</button>
    <button type="submit" value="division" name="asmd">Division</button>
</form>
<p>
    Result ${name}: ${result}
</p>
</body>
</html>
