<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Remote Mac interface</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="static/css/bootstrap.min.css"/>" rel="stylesheet">
    <!-- Bootstrap theme -->
    <link href="<c:url value="static/css/bootstrap-theme.min.css"/>" rel="stylesheet">
</head>
<body>
<div class="container">
<div class="col-md-4 col-md-offset-4" id="input-group input-group-lg">
    <div class="panel-heading">
        <div class="panel-title text-center">
            <h1 class="title">Remote Mac interface</h1>
            <hr />
        </div>
    </div>
    <form class="form-horizontal" id="loginForm" method="post" action="${pageContext.request.contextPath}/login">
        <div class="form-group">
            <div class="input-group">
                <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                <input type="text" name="username" class="form-control" placeholder="Username" aria-describedby="sizing-addon1">
            </div>
        </div>
        <div class="form-group">
            <div class="input-group">
                <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                <input type="password" name="password" class="form-control" placeholder="Password" aria-describedby="sizing-addon1">
            </div>
        </div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <div class="form-group">
            <button type="submit" class="btn btn-primary btn-lg btn-block login-button">Sign in</button>
        </div>
    </form>
</div>
</div>
<!-- Bootstrap core JavaScript
    ================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
<script src="<c:url value="static/js/bootstrap.min.js"/>"></script>
</body>
</html>
