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
    <title>viewComments</title>
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.5.1.min.js"></script>
    <script>

        function insert() {
            var commentJSONArray = ${comment};
            $.each(commentJSONArray, function(idx, obj){
                var box = document.getElementById("box");
                var commentList = box.firstElementChild || box.firstChild;
                commentList.innerHTML += '<div class = commentLine style="background-color: #dfdcb8;"><span class = "commentText" style="margin-left: 20px; font-size: 40px; margin-bottom: 2px">'
                    + obj.description + '</span><br><span style="font-size: 15px; margin-left: 20px; margin-top: 5px"> On Playground: '
                    + obj.name + '</span><br><span style="font-size: 15px; margin-left: 20px; margin-top: 5px">Date: '
                    + new Date(obj.createTime).toDateString()
                    + '</span></div>';

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
            MY COMMENTS
            <hr id = "spLine">
        </div>
        <div class="panelBody">
            <div id = "box">
                <div></div>
            </div>
        </div>

    </div>
</div>
</body>
</html>
