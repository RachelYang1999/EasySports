<%--
  Created by IntelliJ IDEA.
  User: yuanyi
  Date: 2020-10-21
  Time: 20:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manage</title>


    <jsp:include page="welcome_layout.jsp"/>
    <jsp:include page="sideBar.jsp"/>


</head>
<body style="background: url(${pageContext.request.contextPath}/static/image/home_background8.jpg)" >
<div class="alert alert-success" role="alert" style="font-size: 45px;text-align: center;margin-bottom: 0px;margin-left: 5%;margin-right: 5%">
    Manage my bookings
</div>


            <div class="row no-gutters" style="margin-left: 8%">
                <div class="col-md-4">
                    <img src="<%=request.getContextPath()%>/static/image/${image}" class="card-img" style="margin-left: 0%;width: 150%;">
                </div>
                <div class="col-md-8">
                    <div class="card-body" style="margin-left: 35%">
                        <h5 class="card-title" style="font-size: 40px"onclick="location.href='<%=request.getContextPath()%>/playground'">Badminton Worx</h5>
                        <p class="card-text" style="font-size: 25px">${date}</p>
                        <p class="card-text" style="font-size: 25px">${time}</p>
                        <p class="card-text" style="font-size: 25px">Booking message: Please arrive 10 minutes ahead of the booking time. No people limitations, please follow the
                            Covid-19 instructions and stay safe.</p>
                        <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
                    </div>
                    <div>
                        <form class="px-4 py-3" method = post>
                            <span  style="margin-left: 37%;margin-top: 5%;height: 100px;width:109px" >
                                <input type="hidden" name="bookingid" value="${id}">
                                <button style="font-size: 40px;width: 500px;"type="submit" class="btn btn-outline-success" onclick="location.href='<%=request.getContextPath()%>/bookings'" >Press to cancel</button>
<%--                                <img src="<%=request.getContextPath()%>/static/image/cancel.png"   type="submit" style="margin-left: 30%;" onclick="location.href='<%=request.getContextPath()%>/bookings'">--%>
                            </span>
                        </form>

                    </div>
                </div>
        <div style="font-size: 60px;margin-left: 5%;margin-top: 3%;">
            <button style="font-size: 40px;width: 500px;"type="button" class="btn btn-link" onclick="location.href='<%=request.getContextPath()%>/bookings'" >Return to booking page</button>
        </div>
</body>
</html>
