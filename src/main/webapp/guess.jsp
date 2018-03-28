<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alyxandriascott
  Date: 3/28/18
  Time: 11:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Guess</title>
</head>
<body>

<h2>Guess a number between 0 and 100: </h2>

<form action="/guess" method="POST">
    <div>
        <label for="number">Guess here: </label>
        <input id="number" name="number" type="number">
    </div>
    <input type="submit" value="go">
</form>

</body>
</html>
