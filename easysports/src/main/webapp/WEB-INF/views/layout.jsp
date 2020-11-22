<%--
  Created by IntelliJ IDEA.
  User: nicole
  Date: 16/10/20
  Time: 3:50 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
<body>
<nav class="navbar navbar-dark" style="background: #054639; ">
    <a class="navbar-brand" href="#">
<%--        <img src="<%=request.getContextPath()%>/static/image/logo-pic.png" width = 20% alt="" >--%>
        <img src="<%=request.getContextPath()%>/static/image/logo_dark.png" width="95" height="60" alt="" onclick="location.href='<%=request.getContextPath()%>/'">

    </a>
    <form class="form-inline">
        <button class="btn btn-light" type="button" style="margin-right: 20px; color: #3CB371;" onclick="location.href='<%=request.getContextPath()%>/login'">Login</button>
    </form>
</nav>
</body>