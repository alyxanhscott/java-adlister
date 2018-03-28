<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alyxandriascott
  Date: 3/28/18
  Time: 9:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Name Page Drill</title>
</head>
<body>
<c:if test="${not empty error}">
    <h2>${error}</h2>
</c:if>
    <h1>Enter your name: </h1>
    <form action="/name" method="POST">
            <label for="name">Name: </label>
            <input id="name" name="name" type="text">
        <input type="submit" value="go">
    </form>

</body>
</html>
