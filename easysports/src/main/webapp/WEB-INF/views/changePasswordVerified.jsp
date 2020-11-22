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
    <jsp:include page="layout.jsp"/>
<%--    <jsp:include page="sideBar.jsp"/>--%>
    <link href="${pageContext.request.contextPath}/static/css/changePassword.css" rel="stylesheet" type="text/css">
    <title>Change Password</title>
</head>
<body>
    <div class = "wholeBottom">
        <div class = "leftPage">
        </div>

        <div class = "main-page" >
            <div class="alert alert-success" role="alert">
                The answer to your security question is correct! Now you have permission to reset password :)
            </div>

            <div class = "reset-block-with-alert">
                <div class ="login-header">
                    <h1>Reset Your Password</h1>
                </div>

                <div>
                    <br>
                    ${message} <br>
                </div>

                <form class="reset-form" method = "post">
                    <input type="password" id="newPassword" class="form-field" placeholder="New password" name = "newPassword" required>
                    <input type="password" id="verifyPassword" class="form-field" placeholder="Confirm password" name = "verifyPassword" required>
<%--                    <input type="submit" value="Submit" id="form-submit">--%>
                    <button type="submit" class="form-submit" >Submit</button>
                </form>
                <%--                <div class="form-group">--%>
                <%--                    <label for="answer">Enter your answer: </label>--%>
                <%--                    <input type="text" class="form-control" id="answer" placeholder="answer" name="answer" required>--%>
                <%--                </div>--%>
                <%--                <br>--%>
                <%--                ${message} <br>--%>
                <%--                <button type="submit" class="btn btn-primary" style="background: #539770 ;border:2px #0B5345  none;" >Submit</button>--%>
            </div>

        </div>

    </div>
</body>
</html>
