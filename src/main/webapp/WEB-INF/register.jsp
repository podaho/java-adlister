<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="New User Registration" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <div class="container">
        <h1>Register A New User</h1>
        <form action="/register" method="POST">
            <div class="form-group">
                <label for="username">Enter Username</label>
                <input id="username" name="username" class="form-control" type="text">
            </div>
            <div class="form-group">
                <label for="password1">Enter Password</label>
                <input id="password1" name="password1" class="form-control" type="password">
            </div>
            <div class="form-group">
                <label for="password2">Confirm Password</label>
                <input id="password2" name="password2" class="form-control" type="password">
            </div>
            <div class="form-group">
                <label for="email">Enter Email</label>
                <input id="email" name="email" class="form-control" type="email">
            </div>
            <input type="submit" class="btn btn-primary btn-block" value="Submit">
        </form>
    </div>
</body>
</html>
