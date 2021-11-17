<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: TechCare
  Date: 11/17/2021
  Time: 2:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h1>Settings</h1>
<form:form action="/result" method="post" modelAttribute="setting">
    <table>
        <tr>
            <td>Languages</td>
            <td><form:select path="langueges" items="${selectLanguage}"/></td>
        </tr>
        <tr>
            <td>Page Size</td>
            <td>Show <form:select path="pageSize" items="${selectPageSize}"/> emails per page</td>
        </tr>
        <tr>
            <td>Spams Fillter</td>
            <td><form:radiobutton path="spamsFillter"/> Enable spams fillter</td>
        </tr>
        <tr>
            <td>Signature</td>
            <td><form:textarea path="signature" rows="5"/></td>
        </tr>
        <tr>
            <td><input type="reset" value="Reset"></td>
            <td><input type="submit" value="Submit"></td>
        </tr>
    </table>
</form:form>
</body>
</html>
