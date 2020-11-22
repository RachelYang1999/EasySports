<%--
  Created by IntelliJ IDEA.
  User: yangqiuli
  Date: 2020/10/24
  Time: 9:42 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="layout.jsp"/>
    <title>Login</title>
</head>

<body style="background: url(${pageContext.request.contextPath}/static/image/home_background8.jpg)" >
<br/>
<%--<div class="alert alert-danger" role="alert">--%>
<%--    ${message}--%>
<%--</div>--%>
<%--${message}--%>
<div style="width: 400px; height: auto; margin-left: 38%; margin-top: 90px; background: #DCDCDC; opacity: 0.8;">
    <form class="px-4 py-3" method = post>

        <div class="form-group">
            <label for="email">Please enter your email</label>
            <input type="text" class="form-control" id="email" placeholder="email@example.com" name="email" required>
        </div>
        ${message} <br>
        <br>
        <button type="submit" class="btn btn-primary" style="background: #0B5345 ;border:2px #0B5345  none;" >Next</button>

<%--        <button type="submit" class="btn btn-lg btn-danger" style="background: #0B5345 ;border:2px #0B5345  none;" data-toggle="popover" data-content=${message} >Next</button>--%>

    </form>
<%--    <div class="dropdown-divider"></div>--%>
</div>

</body>
</html>
