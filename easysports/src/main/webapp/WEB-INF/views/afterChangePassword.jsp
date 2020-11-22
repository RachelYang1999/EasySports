<%--
  Created by IntelliJ IDEA.
  User: yangqiuli
  Date: 2020/10/27
  Time: 12:00 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="layout.jsp"/>
<%--    <jsp:include page="sideBar.jsp"/>--%>
    <link href="${pageContext.request.contextPath}/static/css/changePassword.css" rel="stylesheet" type="text/css">
    <title>Change Password</title>
</head>

<body>
<div class = "wholeBottom">
    <div class = "leftPage"></div>

    <div class = "main-page" >
        <div class="alert">
            You have changed the password successfully, please login again!
        </div>
<%--        <div class = "login-block">--%>
<%--            </div>--%>
<%--            <button type="submit" class="login-button">Login</button>--%>
<%--        </div>--%>

    </div>
<div/>
</body>
</html>
