<%--
  Created by IntelliJ IDEA.
  User: TechCare
  Date: 11/12/2021
  Time: 6:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Convert</title>
    <link rel="stylesheet" href="/assert/bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="/assert/datatables/css/dataTables.bootstrap4.min.css">
</head>
<body>
<form method="post" action="/convertCurrency">
    <label for="usd">USD:</label>
    <input type="number" name="usd" id="usd" aria-describedby="USD currency">
    <button type="submit" class="btn btn-primary">Convert</button>
</form>
<p>VND: ${usd}</p>

<script src="/assert/bootstrap413/js/popper.min.js"></script>
<script src="/assert/bootstrap413/js/bootstrap.min.js"></script>
<script src="/assert/bootstrap413/js/bootstrap.bundle.js"></script>
</body>
</html>
