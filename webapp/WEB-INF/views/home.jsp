<%--
  Created by IntelliJ IDEA.
  User: nicole
  Date: 16/10/20
  Time: 3:51 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <jsp:include page="layout.jsp"/>
    <jsp:include page="datePicker.jsp"/>
    <link href="${pageContext.request.contextPath}/static/css/style.css" rel="stylesheet" type="text/css">
    <title>Home</title>
</head>

<body background="${pageContext.request.contextPath}/static/image/home_background5.jpg">

    <div class="jumbotron" style="height: 480px; background-image:url('<%=request.getContextPath()%>/static/image/home_background3.png'); width: 1450px; " >
        <h1 class="display-4" style="color: white;">Welcome To EasySports!</h1>
        <p class="lead" style="color: white;">This is a convenient playground booking platform. </p>
        <hr class="my-4" style="color: white;">
        <p style="color: white;">Let's start your trip by searching a playground.</p>
    </div>

    <form class="form-inline" style="margin-top: 40px;">
        <div class="input-group mb-3" style="margin-left: 50px; margin-top: 1%;">
            <div class="input-group-prepend" >
                <label class="input-group-text" style="background:#3CB371;border:2px #3CB371 none;color: white;" for="playgroundTypeInputSelect">Please choose a playground type</label>
            </div>
            <select class="custom-select" id="playgroundTypeInputSelect">
                <option selected>Choose...</option>
                <option value="1">Basketball</option>
                <option value="2">Football</option>
                <option value="3">Baseball</option>
                <option value="3">Swimming</option>
                <option value="3">Others</option>
            </select>
        </div>

        <div class="container-inline" style="margin: 0 auto;">
            <div class="row">
                <div class="col-sm-13">
                    <div class="form-group">
                        <div class="input-group date" id="datetimepicker4" data-target-input="nearest">
                            <button class="btn btn-primary" style="font-size: 16px; background: #3CB371; border:2px #3CB371 none;" type="submit">Choose your preferred time</button>
                            <input type="text" class="form-control datetimepicker-input"  data-target="#datetimepicker4"/>
                            <div class="input-group-append" data-target="#datetimepicker4" data-toggle="datetimepicker">
                                <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                            </div>
                        </div>
                    </div>
                </div>
                <script type="text/javascript">
                    $(function () {
                        $('#datetimepicker4').datetimepicker({
                            format: 'L'
                        });
                    });
                </script>
            </div>
        </div>

        <div class="input-group mb-3" style="margin-right: 50px; margin-top: 1%;">
            <div class="input-group-prepend" >
                <label class="input-group-text" style="background:#3CB371;border:2px #3CB371 none;color: white;" for="maxDistanceInputSelect">Please choose a maximum distance</label>
            </div>
            <select class="custom-select" id="maxDistanceInputSelect">
                <option selected>Choose...</option>
                <option value="1">2km</option>
                <option value="2">5km</option>
                <option value="3">10km</option>
                <option value="3">20km</option>
                <option value="3">None</option>
            </select>
        </div>
    </form>

    <div class="find_btn_home" style="margin-top: 100px; margin-bottom: 50px; text-align: center;">
        <button type="button" class="btn btn-secondary btn-lg" style="background: #3CB371; width: 300px; height: 80px; border:2px #3CB371 none; font-size: 30px;">Find a Playground</button>
    </div>

</body>
</html>
