<%--
  Created by IntelliJ IDEA.
  User: nicole
  Date: 16/10/20
  Time: 3:51 pm
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
<%--    <jsp:include page="layout.jsp"/>--%>
<%--    <jsp:include page="datePicker.jsp"/>--%>
    <link href="${pageContext.request.contextPath}/static/css/style.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/static/css/fullpage.css" rel="stylesheet" type="text/css">
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.5.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/fullpage.js"></script>

    <script type="text/javascript">
        $(document).ready(function() {
            $('#fullpage').fullpage({
                sectionsColor: ['#f2f2f2', '#4BBFC3', '#7BAABE', '#1789bf'],
                anchors: ['page1', 'page2', 'page3', 'page4'],
                navigation: true,
                navigationPosition: 'right',
                afterLoad: function(origin, destination, direction){
                    if(destination.anchor == 'page1'){
                        $(".home-description").delay(500).slideDown(500);
                        $(".home-logo").fadeIn(750);
                    }

                    if(destination.anchor == 'page2'){
                        $("#s2-pic-1").fadeIn(1000);
                        $("#s2-pic-2").delay(500).fadeIn(1000);
                    }

                    if(destination.anchor == 'page3'){
                        $("#s3-pic-1").fadeIn(1000);
                        $("#s3-pic-2").delay(500).fadeIn(1000);
                    }

                    if(destination.anchor == 'page4'){
                        $("#s4-pic-1").fadeIn(1000);
                        $("#s4-pic-2").delay(500).fadeIn(1000);
                    }
                },
                onLeave: function (origin, destination, direction) {
                    if(origin.anchor == 'page1'){
                        $(".home-description").delay(500).slideUp(500);
                        $(".home-logo").fadeOut(500);
                    }

                    if(origin.anchor == 'page2'){
                        $("#s2-pic-1").fadeOut(100);
                        $("#s2-pic-2").fadeOut(100);
                    }

                    if(origin.anchor == 'page3'){
                        $("#s3-pic-1").fadeOut(100);
                        $("#s3-pic-2").fadeOut(100);
                    }
                    if(origin.anchor == 'page4'){
                        $("#s4-pic-1").fadeOut(100);
                        $("#s4-pic-2").fadeOut(100);
                    }
                }

            });
        });

    </script>
    <style>
        .s1{
            top: 0;
            left: 0;
            width:100%;
            height:100%;
            min-width: 1000px;
            z-index:-10;
            zoom: 1;
            background: url("<%=request.getContextPath()%>/static/image/back.jpg") no-repeat;
            background-size: cover;
            background-position: center 0;
        }
    </style>
    <title>Home</title>
</head>

<%--<body background="${pageContext.request.contextPath}/static/image/home_background5.jpg" >--%>
<body>
    <div id = "fullpage">
        <div class="section s1">
            <div class = "home-main">
                <div class = "logo-full">
                    <div class = "home-logo" style = "display: none">
                        <img src="<%=request.getContextPath()%>/static/image/emptyLogo.png">
                    </div>
                    <div class = "home-easy">
                        <img src="<%=request.getContextPath()%>/static/image/easy-em.png">
                    </div>
                    <div class = "home-sports">
                        <img src="<%=request.getContextPath()%>/static/image/sports-em.png">
                    </div>
                    <div class = "home-description" style = "display: none">
                        <img src="<%=request.getContextPath()%>/static/image/time.png">
                    </div>
                    <div class = "home-button">
                        <button type="button" style="background-color: transparent; width: 300px; cursor: pointer;height: 80px; border:3px #87968a solid; font-size: 30px; box-shadow: 0 0 18px #ffffff;" onclick="location.href='<%=request.getContextPath()%>/login'">Login</button>
                    </div>
                </div>

            </div>

        </div>
        <div class="section s2">
            <div class = "section-inside-box">
                <div id = "s2-pic-1" style = "display: none">
                    <img src="<%=request.getContextPath()%>/static/image/gym.jpg" style="overflow: hidden; height: 100%; border-right: 10px solid #c1c1c1" id = "basketball">
                </div>
                <div id = "s2-pic-2" style = "display: none">
                    <img src="<%=request.getContextPath()%>/static/image/map.jpg" style="height: 100%">
                </div>

                <div id = "s2-text" class = "sec-description">
                    <p style = "text-shadow: 15px 15px 15px #000000; z-index: 5">Helps you find the NEAREST and GREATEST gym. </p>
                </div>
                <div class = "ex-button">
                    <button type="button" style="background-color: transparent; width: 200px; cursor: pointer;height: 70px; border:3px #87968a solid; font-size: 30px; box-shadow: 0 0 18px #000000;" onclick="location.href='<%=request.getContextPath()%>/login'">Login</button>
                </div>
            </div>
        </div>
        <div class="section s3">
            <div id = "s3-pic-1" style = "display: none">
                <img src="<%=request.getContextPath()%>/static/image/swim.jpg" style="overflow: hidden; height: 100%; border-left: 10px solid #c1c1c1" id = "swim">
            </div>
            <div id = "s3-pic-2" style = "display: none">
                <img src="<%=request.getContextPath()%>/static/image/running.jpg" style="height: 100%">
            </div>

            <div id = "s3-text" class = "thr-description">
                <p style = "text-shadow: 15px 15px 15px #000000; z-index: 5">In the water,<br> on the ground, burn the time</p>
            </div>
            <div class = "ex-button">
                <button type="button" style="background-color: transparent; width: 200px; cursor: pointer;height: 70px; border:3px #87968a solid; font-size: 30px; box-shadow: 0 0 18px #000000;" onclick="location.href='<%=request.getContextPath()%>/login'">Login</button>
            </div>
        </div>
        <div class="section s4">
            <div id = "s4-pic-1" style = "display: none">
                <img src="<%=request.getContextPath()%>/static/image/comments.jpg" style="overflow: hidden; height: 100%; border: 10px solid #c1c1c1" id = "friends">
            </div>
            <div id = "s4-pic-2" style = "display: none">
                <img src="<%=request.getContextPath()%>/static/image/friends.jpg" style="height: 100%">
            </div>

            <div id = "s4-text" class = "four-description">
                <p style = "text-shadow: 15px 15px 15px #000000; z-index: 5">Via comments,<br>Visit venue</p>
            </div>
            <div class = "ex-button">
                <button type="button" style="background-color: transparent; width: 200px; cursor: pointer;height: 70px; border:3px #87968a solid; font-size: 30px; box-shadow: 0 0 18px #000000;" onclick="location.href='<%=request.getContextPath()%>/login'">Login</button>
            </div>
        </div>
    </div>
<%--    <div class = "mainPage">--%>

<%--    <div class="jumbotron" style="height: 655px; background-image:url('<%=request.getContextPath()%>/static/image/home_background16.jpg'); width: auto; " >--%>
<%--        <h1 class="display-4" style="color: white;">Welcome To EasySports!</h1>--%>
<%--        <p class="lead" style="color: white;">This is a convenient playground booking platform. </p>--%>
<%--        <hr class="my-4" style="color: white;">--%>
<%--        <p style="color: white; font-size: 30px; ">Please login to get started.</p>--%>
<%--    </div>--%>

<%--    <div class="find_btn_home" style="margin-top: 90px; margin-bottom: 50px; text-align: center;">--%>
<%--        <button type="button" class="btn btn-secondary btn-lg" style="background: #3CB371; width: 300px; height: 80px; border:2px #3CB371 none; font-size: 30px;" onclick="location.href='<%=request.getContextPath()%>/login'">Login</button>--%>
<%--    </div>--%>
<%--    </div>--%>

</body>
</html>
