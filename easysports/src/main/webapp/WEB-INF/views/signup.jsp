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
    <title>Signup</title>
    <link href="${pageContext.request.contextPath}/static/css/signup.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/static/css/style.css" rel="stylesheet" type="text/css">
    <style>
        .whole-back{
            top: 0;
            left: 0;
            width:100%;
            height:100%;
            min-width: 1000px;
            zoom: 1;
            background-size: cover;
            background: url("<%=request.getContextPath()%>/static/image/home_background16.jpg") no-repeat center 0;
        }
    </style>
</head>

<body style="margin:0; padding:0; background-size: cover; background: url(${pageContext.request.contextPath}/static/image/home_background16.jpg)">
    ${message}
    <div class = "whole-back">
        <div class = "ex-button">
            <button type="button" style="background-color: transparent; width: 150px; cursor: pointer;height: 70px; border:3px #87968a solid; font-size: 30px; box-shadow: 0 0 18px #000000; " onclick="location.href='<%=request.getContextPath()%>/'">Home</button>
            <button type="button" style="background-color: transparent; width: 150px; cursor: pointer;height: 70px; border:3px #87968a solid; font-size: 30px; box-shadow: 0 0 18px #000000; " onclick="location.href='<%=request.getContextPath()%>/login'">Login</button>
        </div>

        <div class = "signup-box">
            <form class="px-4 py-3" method = post>
                <p style="font-size: 40px">Welcome to Easysports</p>
                <hr>

                <div class = "a">
                    <div class="v">
                        <h2>Sign up</h2>
                        <div class="b">
                            <div class="form-group">
                                <label for="userName">User Name</label>
                                <input type="text" class="form-control" id="userName" placeholder="example_name123" name = "userName" required>
                            </div>
                            <div class="form-group">
                                <label for="email">Email address</label>
                                <input type="email" class="form-control" id="email" placeholder="email@example.com" name = "email" required>
                            </div>
                            <div class="form-group">
                                <label for="password">Password</label>
                                <input type="password" class="form-control" id="password" placeholder="Password" name = "password" required>
                            </div>
                            <div class="form-group">
                                <label for="confirmPassword">Confirm Password</label>
                                <input type="password" class="form-control" id="confirmPassword" placeholder="Repeat password" name = "confirmPassword" required>
                            </div>
                            <div class="form-group">
                                <label for="securityQuestion">Please choose a security question</label>
                                <div >
                                    <select class="form-control" id="securityQuestion" name = "securityQuestion" >
                                        <option selected>Choose...</option>
                                        <option value="1">Where is your birth place?</option>
                                        <option value="2">When is your birthday?</option>
                                        <option value="3">Where is your mother's birth place?</option>
                                        <option value="4">Where is your father's birth place?</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="userName">Your answer</label>
                                <input type="text" class="form-control" id="sq_answer" placeholder="Your answer" name = "answer" required>
                            </div>
                            <button type="submit" class="submit" >Sign up</button>

                        </div>

                    </div>

                </div>


            </form>

            <div class="signup-text">
                <a class="dropdown-item" href="<%=request.getContextPath()%>/login">Already have an account? Login</a>
            </div>

        </div>
    </div>

</body>
</html>
