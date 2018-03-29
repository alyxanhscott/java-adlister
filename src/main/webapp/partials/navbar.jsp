<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="/ads">Adlister</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <%--below code: determines login/logout status based on user status as defined in login/logout servlets--%>
        <c:if test="${not empty user}">
            <li><a href="/logout">Log Out</a></li>
        </c:if>
        <c:if test="${empty user}">
            <li><a href="/login">Login</a></li>
        </c:if>
        </ul>
    </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
