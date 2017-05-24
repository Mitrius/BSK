<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <META http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>User registration</title>
    <!-- Bootstrap core CSS -->
    <link href="<c:url value="static/css/bootstrap.min.css"/>" rel="stylesheet">
    <!-- Bootstrap theme -->
    <link href="<c:url value="static/css/bootstrap-theme.min.css"/>" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">BSK</a>
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="<c:url value="/getTableNames"/>">Tables<span class="sr-only">(current)</span></a></li>
                <li><a href="<c:url value="/getSpecificTable"/>?tableName=Users">Users</a></li>
                <li class="active"><a href="#">Register</a></li>
            </ul>
            <form class="navbar-form navbar-left" action="<c:url value="/logout"/>">
                <button type="submit" class="btn btn-default">Logout</button>
            </form>
        </div>
    </div>
</nav>
<div class="container">
    <div class="col-md-4 col-md-offset-4" id="input-group input-group-lg">
        <div class="panel-heading">
            <div class="panel-title text-center">
                <h1 class="title">Register user</h1>
                <hr />
            </div>
        </div>
        <form class="form-horizontal" method="post" action="<c:url value="/createNewClass/User"/>">
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
            <div class="form-group">
                <label><input id="checkbox1" type="checkbox" name="enabled" class="form-control"aria-describedby="sizing-addon1">Approved</label>
                <label><input list="levels" name="clearanceLevel"><br>Clearance level</label>
                <datalist id="levels">
                    <option value="0">Public</option>
                    <option value="1">Confidential</option>
                    <option value="2">Secret</option>
                    <option value="3">Top secret</option>
                </datalist>
            </div>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <div class="form-group">
                <button type="submit" class="btn btn-primary btn-lg btn-block login-button">Create user</button>
            </div>
        </form>
    </div>
</div>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script>
    $("#checkbox1").on('change', function () {
        if ($(this).is(':checked')) {
            $(this).attr('value', 'true');
        } else {
            $(this).attr('value', 'false');
        }
    });
</script>
</html>
