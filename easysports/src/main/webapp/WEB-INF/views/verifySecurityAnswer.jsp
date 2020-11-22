<%--
  Created by IntelliJ IDEA.
  User: yangqiuli
  Date: 2020/10/25
  Time: 2:14 上午
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
<%--${message}--%>
<div style="width: 400px; height: auto; margin-left: 38%; margin-top: 90px; background: #DCDCDC; opacity: 0.8;">
    <form class="px-4 py-3" method = post>
        <div class="form-group">
            Security question:
        </div>

        <div class="p-3 mb-2 bg-dark text-white">
            ${question}
        </div>
        <div class="form-group">
            <label for="answer">Enter your answer: </label>
            <input type="text" class="form-control" id="answer" placeholder="answer" name="answer" required>
        </div>
        <br>
        ${message} <br>

        <button type="submit" class="btn btn-primary" style="background: #539770 ;border:2px #0B5345  none;" >Submit</button>
<%--        <button type="submit" class="btn btn-primary" onclick="location.href='<%=request.getContextPath()%>/verify-answer'" style="background: #0B5345 ;border:2px #0B5345  none;" >Submit</button>--%>
<%--        <button type="submit" class="btn btn-lg btn-danger" style="background: #0B5345 ;border:2px #0B5345  none;" data-toggle="popover" data-content=${message} >Submit</button>--%>

    </form>
    <%--    <div class="dropdown-divider"></div>--%>
</div>

</body>
</html>
