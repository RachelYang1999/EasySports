<%--
  Created by IntelliJ IDEA.
  User: alan
  Date: 2020/10/21
  Time: 3:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link href="${pageContext.request.contextPath}/static/css/sideBar.css" rel="stylesheet" type="text/css">
<html>
<body>
    <div class = "leftBar">
        <div class="all">
            <div class="box" onclick="location.href='<%=request.getContextPath()%>/viewProfile'">
                <a href="#">
                    <div class="cardMain bg-01"><span class="card-content">My profile</span>
                    </div>            </a>
            </div>

            <div class="box" onclick="location.href='<%=request.getContextPath()%>/viewSearchHistory'">
                <a href="#">
                    <div class="cardMain bg-02"><span class="card-content">Recently Visited</span>
                    </div>            </a>
            </div>
            <div class="box" onclick="location.href='<%=request.getContextPath()%>/viewComments'">
                <a href="#">
                    <div class="cardMain bg-03"><span class="card-content">My Comments</span>
                    </div>            </a>
            </div>
            <div class="box" onclick="location.href='<%=request.getContextPath()%>/viewFavourite'">
                <a href="#">
                    <div class="cardMain bg-04"><span class="card-content">Favourite</span>
                    </div>            </a>
            </div>
            <div class="box" onclick="location.href='<%=request.getContextPath()%>/bookings'">
                <a href="#">
                    <div class="cardMain bg-05"><span class="card-content">My bookings</span>
                    </div>            </a>
            </div>
            <div class="box" onclick="location.href='<%=request.getContextPath()%>/changePassword'">
                <a href="#">
                    <div class="cardMain bg-06"><span class="card-content">Change Password</span>
                    </div>            </a>
            </div>
            <div class="box" onclick="location.href='<%=request.getContextPath()%>/'">
                <a href="#">
                    <div class="cardMain bg-07"><span class="card-content">Log Out</span>
                    </div>            </a>
            </div>
        </div>
    </div>
</body>
</html>
