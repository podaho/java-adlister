<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    if(request.getMethod().equalsIgnoreCase("post")) {
        if(username.equals("admin") && password.equals("password")) {
            response.sendRedirect("/profile.jsp");
        } else {
            response.sendRedirect("/login.jsp");
        }
    }
%>
<html>
    <head>
        <%@ include file="partials/materialize_header.jsp" %>
        <title>Login Page</title>
    </head>
    <body>
        <%@ include file="partials/navbar.jsp" %>
        <form action="/login.jsp" method="post">
            <h3 class="center-align">Login</h3>
            <div class="row">
                <div class="input-field col s4 offset-s4">
                    <input name="username" id="account" type="text" class="validate">
                    <label for="account">Account Name</label>
                </div>
            </div>
            <div class="row">
                <div class="input-field col s4 offset-s4">
                    <input name="password" id="password" type="password" class="validate">
                    <label for="password">Password</label>
                </div>
            </div>
            <br>
            <div class="row">
                <button class="col s4 offset-s4 btn waves-effect waves-light" type="submit" name="action">Submit
                    <i class="material-icons right">send</i>
                </button>
            </div>
        </form>
        <%@ include file="partials/footer.jsp" %>
        <%@ include file="partials/materialize_footer.jsp" %>
    </body>
</html>
