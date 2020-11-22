<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>History</title>
    <jsp:include page="welcome_layout.jsp"/>
    <jsp:include page="sideBar.jsp"/>
    <link href="${pageContext.request.contextPath}/static/css/comments.css" rel="stylesheet" type="text/css">
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.5.1.min.js"></script>
    <script>

        function insert() {
            var playgroundJSONArray = ${history};
            $.each(playgroundJSONArray, function(idx, obj){
                var tempDiv = document.getElementById("inBox");
                var searchResultList = tempDiv.firstElementChild || tempDiv.firstChild;
                searchResultList.innerHTML +=
                    '<div class = "card" style="width: 18rem; height: 25rem; float: left; position: relative; margin: 40px auto; ">\n' +
                    '<form class="px-4 py-3" method = post>' +
                    '                    <img src="${pageContext.request.contextPath}/static/image/'+ obj.imageUrl + '" class="card-img-top">\n' +
                    '                    <div class="card-body" >\n' +
                    '                        <h5 class="card-title">'+ obj.name +'</h5>\n' +
                    '                        <p class="card-text">'+ "Type: " +obj.type +'</p>\n' +
                    '                        <p class="card-text">'+ "Visited Time: " + obj.visitedTime +'</p>\n' +
                    '                        <input type="hidden" name="playgroundid" value="'+ obj.id+'">'+
                    '                        <input type="hidden" name="selectedDay" value="${selectedDay}">'+
                    '                        <button type="submit" class="btn btn-outline-success " style="margin-left: 20%;" onclick="location.href=\'<%=request.getContextPath()%>/playground\'">Press for details</button>' +
                    '                    </div>\n' +
                    '                </form>'+
                    '                </div>'
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
            HISTORY
            <hr id = "spLine">
        </div>
        <div class="panelBody">
            <div id = "inBox">
                <div></div>
            </div>
        </div>



    </div>
</div>
</body>
</html>