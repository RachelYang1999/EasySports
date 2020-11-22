<%--
  Created by IntelliJ IDEA.
  User: nicole
  Date: 26/10/20
  Time: 11:23 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search Result</title>
    <jsp:include page="welcome_layout.jsp"/>
    <jsp:include page="sideBar.jsp"/>
    <link href="${pageContext.request.contextPath}/static/css/comments.css" rel="stylesheet" type="text/css">
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.5.1.min.js"></script>
    <script>
        function showByType(){
            var playgroundJSONArray = ${playgrounds};
            var compare = function (obj1, obj2) {
                var val1 = obj1.type;
                var val2 = obj2.type;
                if (val1 < val2) {
                    return -1;
                } else if (val1 > val2) {
                    return 1;
                } else {
                    return 0;
                }
            }
            playgroundJSONArray = playgroundJSONArray.sort(compare);
            var tempDiv = document.getElementById("inBox");
            var searchResultList = tempDiv.firstElementChild || tempDiv.firstChild;
            searchResultList.innerHTML = '';
            $.each(playgroundJSONArray, function(idx, obj){
                tempDiv = document.getElementById("inBox");
                searchResultList = tempDiv.firstElementChild || tempDiv.firstChild;
                searchResultList.innerHTML +=
                    '<div class = "card" style="width: 18rem; height: 28rem; float: left; position: relative; margin: 40px auto; ">\n' +
                    '<form class="px-4 py-3" method = post>' +
                    '                    <img src="${pageContext.request.contextPath}/static/image/'+ obj.imageUrl + '" class="card-img-top">\n' +
                    '                    <div class="card-body" >\n' +
                    '                        <h5 class="card-title">'+ obj.name +'</h5>\n' +
                    '                        <p class="card-text">'+ "Type: " +obj.type +'</p>\n' +
                    '                        <p class="card-text">'+ "Distance: " + obj.distance + "km"+'</p>\n' +
                    '                        <p class="card-text">'+ "Rating: " + obj.rating +'</p>\n' +
                    '                        <input type="hidden" name="playgroundid" value="'+ obj.id+'">'+
                    '                        <input type="hidden" name="selectedDay" value="${selectedDay}">'+
                    '                        <button type="submit" class="btn btn-outline-success " style="margin-left: 20%;" onclick="location.href=\'<%=request.getContextPath()%>/playground\'">Press for details</button>' +
                    '                    </div>\n' +
                    '                </form>'+
                    '                </div>'
            });
        }
        function showByRating(){
            var playgroundJSONArray = ${playgrounds};
            var compare = function (obj1, obj2) {
                var val1 = obj1.rating;
                var val2 = obj2.rating;
                if (val1 < val2) {
                    return 1;
                } else if (val1 > val2) {
                    return -1;
                } else {
                    return 0;
                }
            }
            playgroundJSONArray = playgroundJSONArray.sort(compare);
            var tempDiv = document.getElementById("inBox");
            var searchResultList = tempDiv.firstElementChild || tempDiv.firstChild;
            searchResultList.innerHTML = '';
            $.each(playgroundJSONArray, function(idx, obj){
                tempDiv = document.getElementById("inBox");
                searchResultList = tempDiv.firstElementChild || tempDiv.firstChild;
                searchResultList.innerHTML +=
                    '<div class = "card" style="width: 18rem; height: 28rem; float: left; position: relative; margin: 40px auto; ">\n' +
                    '<form class="px-4 py-3" method = post>' +
                    '                    <img src="${pageContext.request.contextPath}/static/image/'+ obj.imageUrl + '" class="card-img-top">\n' +
                    '                    <div class="card-body" >\n' +
                    '                        <h5 class="card-title">'+ obj.name +'</h5>\n' +
                    '                        <p class="card-text">'+ "Type: " +obj.type +'</p>\n' +
                    '                        <p class="card-text">'+ "Distance: " + obj.distance + "km"+'</p>\n' +
                    '                        <p class="card-text">'+ "Rating: " + obj.rating +'</p>\n' +
                    '                        <input type="hidden" name="playgroundid" value="'+ obj.id+'">'+
                    '                        <input type="hidden" name="selectedDay" value="${selectedDay}">'+
                    '                        <button type="submit" class="btn btn-outline-success " style="margin-left: 20%;" onclick="location.href=\'<%=request.getContextPath()%>/playground\'">Press for details</button>' +
                    '                    </div>\n' +
                    '                </form>'+
                    '                </div>'
            });
        }
        function showByDistance(){
            var playgroundJSONArray = ${playgrounds};
            var compare = function (obj1, obj2) {
                var val1 = obj1.distance;
                var val2 = obj2.distance;
                if (val1 < val2) {
                    return -1;
                } else if (val1 > val2) {
                    return 1;
                } else {
                    return 0;
                }
            }
            playgroundJSONArray = playgroundJSONArray.sort(compare);
            var tempDiv = document.getElementById("inBox");
            var searchResultList = tempDiv.firstElementChild || tempDiv.firstChild;
            searchResultList.innerHTML = '';
            $.each(playgroundJSONArray, function(idx, obj){
                tempDiv = document.getElementById("inBox");
                searchResultList = tempDiv.firstElementChild || tempDiv.firstChild;
                searchResultList.innerHTML +=
                    '<div class = "card" style="width: 18rem; height: 28rem; float: left; position: relative; margin: 40px auto; ">\n' +
                    '<form class="px-4 py-3" method = post>' +
                    '                    <img src="${pageContext.request.contextPath}/static/image/'+ obj.imageUrl + '" class="card-img-top">\n' +
                    '                    <div class="card-body" >\n' +
                    '                        <h5 class="card-title">'+ obj.name +'</h5>\n' +
                    '                        <p class="card-text">'+ "Type: " +obj.type +'</p>\n' +
                    '                        <p class="card-text">'+ "Distance: " + obj.distance + "km"+'</p>\n' +
                    '                        <p class="card-text">'+ "Rating: " + obj.rating +'</p>\n' +
                    '                        <input type="hidden" name="playgroundid" value="'+ obj.id+'">'+
                    '                        <input type="hidden" name="selectedDay" value="${selectedDay}">'+
                    '                        <button type="submit" class="btn btn-outline-success " style="margin-left: 20%;" onclick="location.href=\'<%=request.getContextPath()%>/playground\'">Press for details</button>' +
                    '                    </div>\n' +
                    '                </form>'+
                    '                </div>'
            });
        }
        function Recommended(){
            var playgroundJSONArray = ${recomlist};
            var tempDiv = document.getElementById("inBox");
            var searchResultList = tempDiv.firstElementChild || tempDiv.firstChild;
            searchResultList.innerHTML = '';
            $.each(playgroundJSONArray, function(idx, obj){
                tempDiv = document.getElementById("inBox");
                searchResultList = tempDiv.firstElementChild || tempDiv.firstChild;
                searchResultList.innerHTML +=
                    '<div class = "card" style="width: 18rem; height: 28rem; float: left; position: relative; margin: 40px auto; ">\n' +
                    '<form class="px-4 py-3" method = post>' +
                    '                    <img src="${pageContext.request.contextPath}/static/image/'+ obj.imageUrl + '" class="card-img-top">\n' +
                    '                    <div class="card-body" >\n' +
                    '                        <h5 class="card-title">'+ obj.name +'</h5>\n' +
                    '                        <p class="card-text">'+ "Type: " +obj.type +'</p>\n' +
                    '                        <p class="card-text">'+ "Distance: " + obj.distance + "km"+'</p>\n' +
                    '                        <p class="card-text">'+ "Rating: " + obj.rating +'</p>\n' +
                    '                        <input type="hidden" name="playgroundid" value="'+ obj.id+'">'+
                    '                        <input type="hidden" name="selectedDay" value="${selectedDay}">'+
                    '                        <button type="submit" class="btn btn-outline-success " style="margin-left: 20%;" onclick="location.href=\'<%=request.getContextPath()%>/playground\'">Press for details</button>' +
                    '                    </div>\n' +
                    '                </form>'+
                    '                </div>'
            });
        }

        function insert() {
            var playgroundJSONArray = ${playgrounds};
            var tempDiv = document.getElementById("inBox");
            var searchResultList = tempDiv.firstElementChild || tempDiv.firstChild;
            searchResultList.innerHTML = '';
            $.each(playgroundJSONArray, function(idx, obj){
                tempDiv = document.getElementById("inBox");
                searchResultList = tempDiv.firstElementChild || tempDiv.firstChild;
                searchResultList.innerHTML +=
                    '<div class = "card" style="width: 18rem; height: 28rem; float: left; position: relative; margin: 40px auto; ">\n' +
                    '<form class="px-4 py-3" method = post>' +
                    '                    <img src="${pageContext.request.contextPath}/static/image/'+ obj.imageUrl + '" class="card-img-top">\n' +
                    '                    <div class="card-body" >\n' +
                    '                        <h5 class="card-title">'+ obj.name +'</h5>\n' +
                    '                        <p class="card-text">'+ "Type: " +obj.type +'</p>\n' +
                    '                        <p class="card-text">'+ "Distance: " + obj.distance + "km"+'</p>\n' +
                    '                        <p class="card-text">'+ "Rating: " + obj.rating +'</p>\n' +
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
        <div class = "left-contain" style = "height: 100%; background-color: rgba(245, 245, 246, 0.55);">
            <h2 style="margin-left: 30px">Order By</h2>
            <hr class="spLine"/>
            <h4 style="margin-left: 30px; cursor: pointer" onclick="showByDistance()">Distance</h4>
            <h4 style="margin-left: 30px; cursor: pointer" onclick="showByRating()">Rating</h4>
            <h4 style="margin-left: 30px; cursor: pointer" onclick="showByType()">Type</h4>
            <br/><br/>
            <h2 style="margin-left: 30px">Category</h2>
            <hr style="margin-left: 30px" class="spLine"/>
            <h4 style="margin-left: 30px; cursor: pointer" onclick="insert()">All</h4>
            <h4 style="margin-left: 30px; cursor: pointer" onclick="Recommended()">Recommended</h4>
        </div>

    </div>

    <div class = "mainPage" >


        <div class = "mainTitle">
            SEARCH RESULT
            <hr class = "spLine">
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