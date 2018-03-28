<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alyxandriascott
  Date: 3/27/18
  Time: 9:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--below code is in progress--%>
<%! boolean isInvalid = false; %>
<%
    if(request.getParameter("invalid") != null) {
        isInvalid = true;
    }
    if(request.getMethod().equalsIgnoreCase("post")) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username.equals("admin") && password.equals("password")) {
            response.sendRedirect("/profile.jsp");
        }
    }
%>

<html>
<head>
    <title>Login</title>
    <%@ include file="partials/head.jsp"%>
</head>
<body>
    <%@ include file="partials/navbar.jsp"%>
    <h2>Enter your Username and Password: </h2>
    <div>
        <form  method="post" action="login.jsp">
            <input name="username" type="text" placeholder="username">
            <input name="password" type="password" placeholder="password">
            <button type="submit">Go</button>
        </form>

    </div>

</body>
</html>
