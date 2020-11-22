<%--
  Created by IntelliJ IDEA.
  User: nicole
  Date: 16/10/20
  Time: 7:45 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <link href="${pageContext.request.contextPath}/static/css/style.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/static/css/login.css" rel="stylesheet" type="text/css">

    <title>Login</title>
    <style>
        .whole-back{
            top: 0;
            left: 0;
            width:100%;
            height:100%;
            min-width: 1000px;
            zoom: 1;
            background-size: cover;
            background: url("<%=request.getContextPath()%>/static/image/home_background16.jpg") no-repeat center;
            background-size: cover;
        }
    </style>
</head>

<body  style = "margin:0px; padding:0px;">
    ${message}
    <div class = "whole-back">
        <div class = "ex-button">
            <button type="button" style="background-color: transparent; width: 150px; cursor: pointer;height: 70px; border:3px #87968a solid; font-size: 30px; box-shadow: 0 0 18px #000000; " onclick="location.href='<%=request.getContextPath()%>/'">Home</button>
            <button type="button" style="background-color: transparent; width: 150px; cursor: pointer;height: 70px; border:3px #87968a solid; font-size: 30px; box-shadow: 0 0 18px #000000; " onclick="location.href='<%=request.getContextPath()%>/signup'">Sign Up</button>
        </div>

        <div class = "login-box">
            <form method = post class = "login-form">
                <p style="font-size: 40px">Welcome to Easysports</p>
                    <hr>
                <div class="a">
                    <div class="v" style="z-index: 10;">
                        <h2>Log In</h2>
                        <div class="b" id="b">
                            <label for="login_email">Email address</label>
                            <input type="text" class="input" id="login_email" placeholder="email@example.com" name="email"/>
                            <br/>
                            <label for="login_password">Password</label>
                            <input type="password"  class="input" id="login_password" placeholder="Password"  name="password" required/>
                            <button type="submit" class="submit">Login</button>
                        </div>
                    </div>
                </div>
            </form>
            <div class = "login-text">
                <a href="<%=request.getContextPath()%>/forgotPassword" style="text-decoration:none; color: #3a3a3a">Forgot password?</a>
            </div>

            </div>
    </div>



</body>
</html>
