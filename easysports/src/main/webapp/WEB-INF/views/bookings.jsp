<%--
  Created by IntelliJ IDEA.
  User: alan
  Date: 2020/10/20
  Time: 8:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <jsp:include page="welcome_layout.jsp"/>
    <jsp:include page="sideBar.jsp"/>
    <link href="${pageContext.request.contextPath}/static/css/comments.css" rel="stylesheet" type="text/css">
    <title>bookings</title>
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.5.1.min.js"></script>
    <script>

        function insert() {
            var commentJSONArray = ${booking};
            $.each(commentJSONArray, function(idx, obj){
                var box = document.getElementById("box");
                var bookinglist = box.firstElementChild || box.firstChild;
                bookinglist.innerHTML += '<form class="px-4 py-3" method = post>'
                +'<div class = bookingLine style="margin-top: 8%"><span class = "commentText" style="margin-left: 20px; font-size: 40px; margin-bottom: 6px">'
                    + '</span><br><span style="font-size: 25px; margin-left: 20px; margin-top: 10px"> Playground: '
                    +'  '+ obj.playgroundname+'</span><br><span style="font-size: 25px; margin-left: 20px; margin-top: 5px">Booking date: '
                    +'<input type="hidden" name="bookingid" value="'+ obj.id+'">'
                    + obj.bookingdate+'<button type="submit" class="btn btn-outline-success " style="margin-left: 20%" onclick="location.href=\'<%=request.getContextPath()%>/manage\'">Press for details</button>'
                    + '</span></div>'
                +'</form>';
            });
        }

    </script>

</head>
<body onload = insert()>

<div class = "wholeBottom">
    <div class = "leftPage">

    </div>

    <div class = "mainPage" >
        <div class = "mainTitle">
            MY Bookings
            <hr id = "spLine">
        </div>
        <div class="panelBody">
            <div id = "box" style="border: #0B5345">
                <div style="border: 20px none #3CB371"></div>
            </div>
        </div>

    </div>
</div>
</body>
</html>
