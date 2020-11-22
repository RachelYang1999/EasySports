<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: nicole
  Date: 21/10/20
  Time: 4:26 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="welcome_layout.jsp"/>
    <jsp:include page="newDatePicker.jsp"/>
    <link href="${pageContext.request.contextPath}/static/css/style.css" rel="stylesheet" type="text/css">
    <title>Welcome</title>
    <%
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        String date= format.format(new Date());
    %>
</head>
<body background="${pageContext.request.contextPath}/static/image/home_background5.jpg">
    <div id="carouselExampleCaptions" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
            <li data-target="#carouselExampleCaptions" data-slide-to="0" class="active"></li>
            <li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
            <li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src="<%=request.getContextPath()%>/static/image/swim.jpg" height="630" style = "object-fit: cover;" class="d-block w-100" >
                <div class="carousel-caption d-none d-md-block">
                    <h2>Easy Sports</h2>
                    <p>Helps you find the NEAREST and GREATEST gym.</p>
                </div>
            </div>
            <div class="carousel-item">
                <img src="<%=request.getContextPath()%>/static/image/red.png" height="630" style = "object-fit: cover;" class="d-block w-100" >
                <div class="carousel-caption d-none d-md-block">
                    <h2>Easy Sports</h2>
                    <p>On the ground, in the water, burn the time.</p>
                </div>
            </div>
            <div class="carousel-item">
                <img src="<%=request.getContextPath()%>/static/image/black.png" height="630" style = "object-fit: cover;" class="d-block w-100" >
                <div class="carousel-caption d-none d-md-block">
                    <h2>Easy Sports</h2>
                    <p>We are your best friends. We are the people who know you best.</p>
                </div>
            </div>
        </div>
        <a class="carousel-control-prev" href="#carouselExampleCaptions" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#carouselExampleCaptions" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>


    <form  style="margin-top: 40px;" method="post">
        <div class="form-inline">
            <div class="input-group mb-3" style="margin-left: 50px; margin-top: 1%;">
                <div class="input-group-prepend" >
                    <label class="input-group-text" style="background:#3CB371;border:2px #3CB371 none;color: white;" for="playgroundTypeInputSelect">Please choose a playground type</label>
                </div>
                <select class="custom-select" id="playgroundTypeInputSelect" name = "playgroundType">
                    <option selected>Choose...</option>
                    <option value="1">Basketball</option>
                    <option value="2">Badminton</option>
                    <option value="3">Baseball</option>
                    <option value="4">Swimming</option>
                    <option value="5">Tennis</option>
                </select>
            </div>

            <div class="container-inline" style="margin: 0 auto;">
                <div class="row">
                    <label class="input-group-text" style="font-size: 16px; background: #3CB371; border:2px #3CB371 none; color: white;" >Choose your preferred day</label>
                    <input type="text" id="datepicker" style="border: darkgray;" name = "preferredDay" value="<%=date%>"/>
                </div>
            </div>

            <div class="input-group mb-3" style="margin-right: 50px; margin-top: 1%;">
                <div class="input-group-prepend" >
                    <label class="input-group-text" style="background:#3CB371;border:2px #3CB371 none;color: white;" for="maxDistanceInputSelect">Please choose a maximum distance</label>
                </div>
                <select class="custom-select" id="maxDistanceInputSelect" name = "preferredDistance">
                    <option selected>Choose...</option>
                    <option value="1">2km</option>
                    <option value="2">5km</option>
                    <option value="3">10km</option>
                    <option value="4">20km</option>
                </select>
            </div>
        </div>

        <div class="form-group" style="margin-top: 100px; margin-bottom: 50px; text-align: center;">
            <button type="submit" class="btn btn-outline-success"  style=" width: 300px; height: 80px;  font-size: 30px;">Find a Playground</button>
        </div>
    </form>


</body>
</html>
