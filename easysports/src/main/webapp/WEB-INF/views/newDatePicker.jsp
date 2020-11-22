<%--
  Created by IntelliJ IDEA.
  User: nicole
  Date: 29/10/20
  Time: 12:03 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="//apps.bdimg.com/libs/jqueryui/1.10.4/css/jquery-ui.min.css">
    <script src="//apps.bdimg.com/libs/jquery/1.10.2/jquery.min.js"></script>
    <script src="//apps.bdimg.com/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>
    <link rel="stylesheet" href="jqueryui/style.css">
    <script>
        $(function() {
            $( "#datepicker" ).datepicker({  minDate: 0, maxDate: "+65D" });
        });
    </script>
</head>
</html>