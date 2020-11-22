<%--
  Created by IntelliJ IDEA.
  User: yangqiuli
  Date: 2020/10/25
  Time: 6:25 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="welcome_layout.jsp"/>
    <jsp:include page="sideBar.jsp"/>
    <link href="${pageContext.request.contextPath}/static/css/changePassword.css" rel="stylesheet" type="text/css">
    <title>Change Password</title>
</head>
<body>
    <div class = "wholeBottom">
        <div class = "leftPage">
        </div>

        <div class = "main-page" >

            <div class = "reset-block">
                <div class ="login-header">
                    <h1>Reset Your Password</h1>
                </div>

                <div class="form-group">
                    <label for="email">Please enter your email</label>
                    <input type="text" class="form-control" id="email" placeholder="email@example.com" name="email">

                    <label for="previousPassword">Previous password: </label>
                    <input type="password" class="form-control" id="previousPassword" placeholder="Previous password" name="previousPassword">
                </div>
                <br>
                ${message} <br>

                <button type="submit" class="btn btn-primary">Submit</button>


<%--                <form class="reset-form">--%>
<%--                    <input type="password" name="Previous password" id="previous-password" class="form-field" placeholder="Previous password">--%>
<%--                    <input type="password" name="New password" id="new-password" class="form-field" placeholder="New password">--%>
<%--                    <input type="password" name="Verify password" id="verify-password" class="form-field" placeholder="Verify new password">--%>
<%--                    <input type="submit" value="Submit" id="form-submit">--%>
<%--                </form>--%>
            </div>

        </div>

    </div>
</body>
</html>
