<%--
  Created by IntelliJ IDEA.
  User: nicole
  Date: 17/10/20
  Time: 12:06 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="layout.jsp"/>
    <title>Signup</title>
</head>

<body style="background: url(${pageContext.request.contextPath}/static/image/home_background8.jpg)">

<div style="width: 400px; height: 550px; margin-left: 38%; margin-top: 50px; background: #DCDCDC">
    <form class="px-4 py-3">
        <div class="form-group">
            <label for="signupUsername">User Name</label>
            <input type="text" class="form-control" id="signupUsername" placeholder="example_name123">
        </div>
        <div class="form-group">
            <label for="signupEmail">Email address</label>
            <input type="email" class="form-control" id="signupEmail" placeholder="email@example.com">
        </div>
        <div class="form-group">
            <label for="signupPassword">Password</label>
            <input type="password" class="form-control" id="signupPassword" placeholder="Password">
        </div>
        <div class="form-group">
            <label for="confirmPassword">Confirm Password</label>
            <input type="password" class="form-control" id="confirmPassword" placeholder="Repeat password">
        </div>
        <div class="form-group">
            <div class="form-check">
                <input type="checkbox" class="form-check-input" id="signupCheck">
                <label class="form-check-label" for="signupCheck">
                    Remember me
                </label>
            </div>
        </div>
        <button type="submit" class="btn btn-primary" style="background: #3CB371;border:2px #3CB371 none;">Sign up</button>
    </form>
    <div class="dropdown-divider"></div>
    <a class="dropdown-item" href="#">Already have an account? Login</a>
</div>

</body>
</html>
