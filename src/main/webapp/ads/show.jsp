<%--
  Created by IntelliJ IDEA.
  User: alyxandriascott
  Date: 3/28/18
  Time: 3:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Selected Ad</title>
    <jsp:include page="/partials/head.jsp">
        <jsp:param name="title" value="Selected Ad"/>
    </jsp:include>
</head>
<body>
<jsp:include page="/partials/navbar.jsp"/>

    <h4>${ad.getTitle()}</h4>
    <li>${ad.getDescription()}</li>
    <li>ID: ${ad.getId()}</li>
    <li>UserID: ${ad.getUserId()}</li>

</body>
</html>
