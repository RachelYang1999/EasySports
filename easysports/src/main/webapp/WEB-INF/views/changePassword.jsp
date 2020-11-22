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

    <script>
        function insert() {
            var r = ${result};
            if (r === "success") {
                var para = document.createElement("p");
                var node = document.createTextNode("You have changed the password successfully, please login again!");
                para.appendChild(node);
                var element = document.getElementById("message");
                element.appendChild(para);
            }
        }
    </script>

</head>
<body onload = insert()>
    <div class = "wholeBottom">
        <div class = "leftPage">
        </div>

        <div class = "main-page" >
<%--            <div id = "message"></div>--%>

            <form class = "reset-block" method = post>
                <div class ="login-header">
                    <h1>Reset Your Password</h1>
                </div>

                <div class="reset-form">
<%--                    <input type="text" class="form-control" id="email" placeholder="email@example.com" name="email">--%>
                    <input type="password" name="previousPassword" id="previousPassword" class="form-control" placeholder="Previous password">
                    <input type="password" name="newPassword" id="newPassword" class="form-control" placeholder="New Password">
                    <input type="password" name="verifyPassword" id="verifyPassword" class="form-control" placeholder="Confirm Password">
                </div>
                ${message}
                <button type="submit" class="form-submit">Submit</button>

            </form>

        </div>

    </div>
</body>
</html>
