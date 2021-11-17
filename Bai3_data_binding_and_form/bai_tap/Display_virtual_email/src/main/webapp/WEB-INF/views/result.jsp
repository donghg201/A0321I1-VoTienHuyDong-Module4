<%--
  Created by IntelliJ IDEA.
  User: TechCare
  Date: 11/17/2021
  Time: 3:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<td>Setting</td>
<table>
    <tr>
        <td>Languages</td>
        <td>${setting.langueges}</td>
    </tr>
    <tr>
        <td>Page Size</td>
        <td>${setting.pageSize}</td>
    </tr>
    <tr>
        <td>Spams Fillter</td>
        <td>${setting.spamsFillter}</td>
    </tr>
    <tr>
        <td>Signature</td>
        <td>${setting.signature}</td>
    </tr>
</table>
</body>
</html>
