<%--
  Created by IntelliJ IDEA.
  User: Wang
  Date: 2020/10/27
  Time: 22:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>view Favourite</title>
    <jsp:include page="welcome_layout.jsp"/>
    <jsp:include page="sideBar.jsp"/>
    <link href="${pageContext.request.contextPath}/static/css/comments.css" rel="stylesheet" type="text/css">
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.5.1.min.js"></script>
    <script>

        function insert() {
            var playgroundJSONArray = ${playgrounds};
            $.each(playgroundJSONArray, function(idx, obj){
                var tempDiv = document.getElementById("inBox");
                var searchResultList = tempDiv.firstElementChild || tempDiv.firstChild;
                searchResultList.innerHTML +=
                    '<div class = "card" style="width: 18rem; height: 25rem; float: left; position: relative; margin: 40px auto; ">\n' +
                    '<form name="frm" class="px-4 py-3" method = post action="<%=request.getContextPath()%>/deleteFavourite">' +
                    '                    <img src="${pageContext.request.contextPath}/static/image/'+ obj.imageUrl + '" class="card-img-top">\n' +
                    '                    <div class="card-body" >\n' +
                    '                        <h5 class="card-title">'+ obj.name +'</h5>\n' +
                    '                        <p class="card-text">'+ "Type: " +obj.type +'</p>\n' +
                    '                        <input type="hidden" name="playgroundid" value="'+ obj.id+'">'+
                    '                         <button type="submit" class="btn btn-outline-success " onclick="OnBtnDetailClick()">Press for details</a>' + '<br>' +
                    '                         <button type="submit" class="btn btn-outline-success " onclick="OnBtnDeleteClick()">Delete</button>' +
                    '                    </div>\n' +
                    '                </form>'+
                    '                </div>'
            });
        }

        function OnBtnDetailClick(){
            var frmObj = document.getElementsByName("frm")[0];
            frmObj.action = "<%=request.getContextPath()%>/viewFavourite";
            frmObj.submit();
        }

        function OnBtnDeleteClick(){
            var frmObj = document.getElementsByName("frm")[0];
            frmObj.action = "<%=request.getContextPath()%>/deleteFavourite";
            frmObj.submit();
        }
    </script>
</head>
<body onload = insert()>

<div class = "wholeBottom" id = "TEST">
    <div class = "leftPage">

    </div>

    <div class = "mainPage" >

        <div class = "mainTitle">
            FAVOURITE PLAYGROUNDS
            <hr id = "spLine">
        </div>
        <div class="panelBody">
            ${message}
            <div id = "inBox">
                <div></div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
