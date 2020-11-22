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
    <title>Playground</title>


    <link href="${pageContext.request.contextPath}/static/css/style.css" rel="stylesheet" type="text/css">
    <title>Home</title>    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
    <link href="${pageContext.request.contextPath}/static/css/playground.css" rel="stylesheet" type="text/css">
    <jsp:include page="welcome_layout.jsp"/>
    <jsp:include page="newDatePicker.jsp"/>
    <jsp:include page="sideBar.jsp"/>
    <link href="${pageContext.request.contextPath}/static/css/comments.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/static/css/commentArea.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/static/css/textarea.css" rel="stylesheet" type="text/css">

    <script src="${pageContext.request.contextPath}/static/js/jquery-3.5.1.min.js"></script>
    <script>
        function sendComment(){
            var xmlhttp;
            xmlhttp = new XMLHttpRequest();
        }

        function covid(){
            alert("Please refer to the notice from the government to decide whether or not to book the playground during the important period of epidemic prevention and control." +
                "\nFor more details, please have a look through this link: " +
                "\nhttps://www.nsw.gov.au/covid-19/latest-news-and-updates")
        }

        function commentAjax(){
            var $textArea = $('#myform'),
                textArea = $textArea.val();
            $.ajax({
                type: "post",
                url: "<%=request.getContextPath()%>/submitComment",
                data:{
                    "description": textArea
                },
                // data:$("#myform").serialize(),
                success(comment){
                    alert("your comment has been post!");
                    var box = document.getElementById("box");
                    var commentList = box.firstElementChild || box.firstChild;
                    commentList.innerHTML += '<div class = commentLine><span class = "commentText" style="margin-left: 20px; font-size: 40px; margin-bottom: 2px">'
                        + comment.description + '</span>'
                        + '</div>';
                }
            })
        }

        function insert() {
            var commentJSONArray = ${avaiabletime};
            $.each(commentJSONArray, function(idx, obj){

                var box = document.getElementById("inbox");

                if (obj.timeType==1){
                    var time="9:00 - 11:00"
                }
                if (obj.timeType==2){
                    var time="11:00 - 13:00"
                }
                if (obj.timeType==3){
                    var time="13:00 - 15:00"
                }
                if (obj.timeType==4){
                    var time="15:00 - 17:00"
                }
                if (obj.timeType==5){
                    var time="17:00 - 19:00"
                }

                var bookinglist = box.firstElementChild || box.firstChild;
                bookinglist.innerHTML += '<div class = dateLine style="margin-left: 20%;margin-top: 5%">'
                    +'<form class="px-4 py-3" method = post>'
                    +'<input type="hidden" name="bookingtimeid" value="'+ obj.id+'">'
                    + '<button type="submit" class="btn btn-outline-success" onclick="location.href=\'<%=request.getContextPath()%>/bookings\'" >'
                    +time
                    +'</button>'
                    +'</form>'
                    + '</div>';

            });

            var playGroundJson = ${commentCurr};
            $.each(playGroundJson, function(idx, obj){
                var box = document.getElementById("box");
                var commentList = box.firstElementChild || box.firstChild;
                commentList.innerHTML += '<div class = commentLine><span class = "commentText" style="margin-left: 20px; font-size: 40px; margin-bottom: 2px">'
                    + obj.description + '</span>'
                    + '</div>';

            });
        }

        function loadFavouriteBtnState(){
            $.ajax({
                url:"<%=request.getContextPath()%>/checkFavourite",
                dataType:"json",
                type:"get",
                async:false,
                data:{
                    playgroundId:"${playgroundId}",
                },
                success:function(res){
                    if (res) {
                        $("#favourite-btn").text("Cancel Favourite");
                        $("#favourite-btn").removeAttr("onclick")
                        $("#favourite-btn").attr("onclick", "deleteFavouritePlayground()");
                    }
                    else {
                        $("#favourite-btn").text("Add to favourite");
                        $("#favourite-btn").removeAttr("onclick")
                        $("#favourite-btn").attr("onclick", "addFavouritePlayground()");
                    }
                }
            });
        }

        function addFavouritePlayground(){
            $.ajax({
                url:"<%=request.getContextPath()%>/addFavourite",
                dataType:"json",
                type:"post",
                async:false,
                data:{
                    playgroundId:"${playgroundId}",
                },
                success:function(res){
                        loadFavouriteBtnState();
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {


                },
                complete: function (XMLHttpRequest, textStatus) {
                    loadFavouriteBtnState();
                }
            });
        }

        function deleteFavouritePlayground(){
            $.ajax({
                url:"<%=request.getContextPath()%>/deleteFavour",
                dataType:"json",
                type:"post",
                data:{
                    playgroundid:"${playgroundId}",
                },
                success:function(res){
                        loadFavouriteBtnState();
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {


                },
                complete: function (XMLHttpRequest, textStatus) {
                    loadFavouriteBtnState();
                }
            });
        }


        function loadPage(){
            insert();
            loadFavouriteBtnState();
            covid();
        }


    </script>



</head>
<body style="background: url(${pageContext.request.contextPath}/static/image/home_background8.jpg)" onload = loadPage()> >


<div class="alert alert-success" role="alert" style="font-size: 45px;text-align: center;margin-bottom: 0px;margin-left: 10%;margin-right: 10%">

    ${playgroundtype}
</div>
<div>
    <div>
        <style>
            body,p{margin: 0;}
            .parent{
                display: grid;
                grid-template-columns:repeat(3,1fr);
                grid-gap:0px;
                height: 400px;
            }
        </style>
        <div class="parent">
            <div class="child">
                <div style="height: 350px; background-image:url('<%=request.getContextPath()%>/static/image/${image1}'); width: 286px; margin-left: 20%;margin-top: 10%" >
                    <h1 class="display-4" style="color: white ;margin-left: 25%; margin-top: 0px;">Entrance</h1>
                </div>

            </div>
            <div class="child">
                <div style="height: 350px; background-image:url('<%=request.getContextPath()%>/static/image/${image2}'); width: 286px; margin-left: 5%;margin-top: 10%" >
                    <h1 class="display-4" style="color: white ;margin-left: 8%; margin-top: 0px;">Playground</h1>
                </div>

            </div>
            <div class="child"style="margin-left: 0%">
                <div class="card-body">
                    <h5 class="card-title" style="font-size: 45px" >${playgroundname}</h5>
                    <p class="card-text" style="font-size: 30px;margin-top: 0%">${rating}</p>
                    <p class="card-text" style="font-size: 30px;margin-top: 0%">${bookreauire}</p>
                    <p class="card-text" style="font-size: 30px;margin-top: 0%">${address}</p>
                    <p class="card-text"><small class="text-muted">Last updated 3 month ago</small></p>
                    <span><button id="favourite-btn" type="submit" class="btn btn-primary" style="font-size: 16px; background: #3CB371; border:2px #3CB371 none;"></button></span>
                </div>

                <div class="row">
                    <div class="col-sm-13">
                        <div class="form-group">
                            <span><button class="btn btn-primary" style="font-size: 16px;  margin-left: 25%;background: #3CB371; border:2px #3cb371 none;">Choose the time</button></span>

                            <span>
                                    <div id = "inbox" style="border: #0B5345">
                                        <div></div>
                                    </div>

                                </span>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>

</div>

<div class="comment-area">

    <p style = "font-size: large">recent comments:</p>
    <div class="panelBody">
        <div id = "box" style="opacity: 80%; ">
            <div></div>
        </div>
    </div>
    <form action = "#" method = "post" class = "comment-form" >
        <div class="form-group">
            <textarea id="myform" class="form-control" rows="3" style = "-webkit-box-sizing: border-box;-moz-box-sizing: border-box;box-sizing: border-box;width: 500px;"></textarea>
            <label for="myform">Leave a comment here</label>
        </div>
        <br/>
        <input type = "button" class="btn btn-primary" style="font-size: 16px; background: #3CB371; border:2px #3cb371 none;" value = "submit" name = "comment" onclick="commentAjax()">
    </form>
</div>

<div class = "comment-show">

</div>

</body>
</html>
