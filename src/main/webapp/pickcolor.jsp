<%--
  Created by IntelliJ IDEA.
  User: alyxandriascott
  Date: 3/28/18
  Time: 11:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pick Color</title>
</head>
<body>
<c:if test="${not empty error}">
    <h2>${error}</h2>
</c:if>

<h2>Enter your favorite color: </h2>

<form action="/pickcolor" method="POST">
    <div>
        <label for="color">Color: </label>
        <input id="color" name="color" type="text">
    </div>
    <input type="submit" value="go">
</form>

</body>
</html>
